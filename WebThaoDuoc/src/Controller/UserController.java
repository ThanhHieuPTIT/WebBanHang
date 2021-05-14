package Controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Bean.Cart;
import Entity.DonHang;
import Entity.SanPham;

@Transactional
@Controller
@RequestMapping("user/")
public class UserController {
	@Autowired
	SessionFactory factory;
	
	
	@RequestMapping("home")
	public String home(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<SanPham> list = query.list();
		model.addAttribute("sanpham", list);
		return "user/home";
	}
	
	@RequestMapping("cart-show")
	public String showCart(HttpSession session) {
		return "user/cart";
	}
	
	@RequestMapping("cart-them/{maSP}")
	public String themCart(HttpSession session,@PathVariable("maSP") int maSP) {
		Session sessionNew = factory.openSession();
		Transaction t = sessionNew.beginTransaction();
		SanPham sanpham = (SanPham)sessionNew.get(SanPham.class,maSP);
		sessionNew.close();
		Cart cart =(Cart) session.getAttribute("cart");
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addItem(sanpham, 1);
		return "redirect:/user/home.htm";
	}
	
	//Xoa mat hang theo maSP
	@RequestMapping("cart-xoa/{maSP}") 
	public String xoaCartItem(HttpSession session,@PathVariable("maSP") int maSP) {
		Session sessionNew = factory.openSession();
		Transaction t = sessionNew.beginTransaction();
		SanPham sanpham = (SanPham)sessionNew.get(SanPham.class,maSP);
		Cart cart =(Cart) session.getAttribute("cart");
		cart.deleteItem(sanpham);
		sessionNew.close();
		return "redirect:/user/cart-show.htm";
		}
	
	// sua san pham trong cart
	@RequestMapping("cart-sua/{maSP}") 
	public String suaCart(HttpSession session,@PathVariable("maSP") int maSP,@RequestParam("sl") int sl) {
		Session sessionNew = factory.openSession();
		Transaction t = sessionNew.beginTransaction();
		SanPham sanpham = (SanPham)sessionNew.get(SanPham.class,maSP);
		Cart cart =(Cart) session.getAttribute("cart");
		cart.updateItem(sanpham, sl);
		return "redirect:/user/cart-show.htm";
	}
	
	@RequestMapping("reset-cart")
	public String resetCart(HttpSession session) {
		Cart cart =(Cart) session.getAttribute("cart");
		if(cart!=null) {
			cart.clear();
		}
		return "redirect:/user/cart-show.htm";
	}
	
	@RequestMapping("thanh-toan") 
	public String thanhToan() {
		return "user/thanhtoan";
	}
	
	
	@RequestMapping(value="end-thanh-toan",method = RequestMethod.POST) 
	public String endThanhToan(HttpSession session,@ModelAttribute("donhang")DonHang dh,ModelMap model) {		
		Session sessionNew = factory.openSession();
		Transaction t = sessionNew.beginTransaction();
		Cart cart =(Cart) session.getAttribute("cart");
		
		if(cart != null) {
			Date date = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String time = formatter.format(date);
			DonHang donhang = new DonHang(dh.getTenKH(),dh.getDiaChi(),dh.getsDT(), dh.getEmail(), time,cart.getTongTien(),"Chưa xác nhận");
			
			sessionNew.save(donhang);
			t.commit();	
			model.addAttribute("message","Đặt hàng thành công !");
			resetCart(session);
		} else {
			model.addAttribute("message","Giỏ hàng chưa có sản phẩm !");		
		}
		
		sessionNew.close();
		return "user/thanhtoan";
	}
	
}

