package Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;

import Bean.Mailer;
import Entity.Admin;
import Entity.DonHang;
import Entity.SanPham;


@Transactional
@Controller
@RequestMapping("admin/")
public class AdminController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("sanpham")
	public String showsanpham(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham";
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		model.addAttribute("sanpham",list);
		return "admin/sanpham";
	}
	
	@RequestMapping("sanpham/show-them")
	String showThemt(ModelMap model) {
		SanPham sanpham = new SanPham();
		model.addAttribute("sanpham", sanpham);
		return "admin/insert-sp";
	}
	
	@RequestMapping("sanpham/delete/{maSP}")
	public String delete(ModelMap model,@PathVariable("maSP") int maSP) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			SanPham sanpham = (SanPham)session.get(SanPham.class,maSP);
			session.delete(sanpham);
			t.commit();
			//model.addAttribute("message","Xóa thành công!");
		}
		catch (Exception e) {
			t.rollback();
			//model.addAttribute("message","Xóa bại!");
		}
		finally {
			session.close();
		}
		return "redirect:/admin/sanpham.htm";
	}
	
	
	@Autowired
	ServletContext context;
	@RequestMapping(value="sanpham/them",method=RequestMethod.POST)
	public String insert(ModelMap model,
			@RequestParam("tenSP")String tenSP,
			@RequestParam("anhSP")MultipartFile anhSP,
			@RequestParam("soLuong")int soLuong,
			@RequestParam("donGia")float donGia,
			@RequestParam("moTa")String moTa)
	{
		if(anhSP.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file ảnh!");
		}else{
			try {
				String path = context.getRealPath("/images/" + anhSP.getOriginalFilename());
				anhSP.transferTo(new File(path));
				
				SanPham sanpham = new SanPham(tenSP,anhSP.getOriginalFilename(),soLuong,donGia,moTa);
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				session.save(sanpham);
				t.commit();		
				
				session.close();
				return "redirect:/admin/sanpham.htm";
			}
			
			catch(Exception e){
				model.addAttribute("message", "Lỗi lưu file!");
			}
		}
		return "redirect:/admin/sanpham/show-them.htm";
	}
	
	@RequestMapping("sanpham/sua/{maSP}")
	public String update(ModelMap model,@PathVariable("maSP") int maSP)
	{
		Session session = factory.getCurrentSession();
		SanPham sanpham = (SanPham) session.get(SanPham.class, maSP);
		model.addAttribute("sanpham",sanpham);
		return "admin/sua-sp";
	}
	
	@RequestMapping(value="sanpham/sua",method=RequestMethod.POST)
	public String capNhat(ModelMap model,
			@RequestParam("maSP")int maSP,
			@RequestParam("tenSP")String tenSP,
			@RequestParam("anhSP")MultipartFile anhSP,
			@RequestParam("soLuong")int soLuong,
			@RequestParam("donGia")float donGia,
			@RequestParam("moTa")String moTa)
	{
		if(anhSP.isEmpty()){
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			SanPham sanpham = (SanPham)session.get(SanPham.class,maSP);
			sanpham.setTenSP(tenSP);
			sanpham.setSoLuong(soLuong);
			sanpham.setDonGia(donGia);
			sanpham.setMoTa(moTa);
			session.update(sanpham);
			t.commit();	
			session.close();
			return "redirect:/admin/sanpham.htm";
		}else{
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
//				byte[] hinhanh_multipart = anhSP.getBytes();	
//				Path path = Paths.get("D:\\Source Code\\Eclipse\\WebThaoDuoc\\WebContent\\images\\"
//						+ anhSP.getOriginalFilename());
//				Files.write(path, hinhanh_multipart);
				String path = context.getRealPath("/images/" + anhSP.getOriginalFilename());
				anhSP.transferTo(new File(path));
				
				SanPham sanpham = (SanPham)session.get(SanPham.class,maSP);
				sanpham.setTenSP(tenSP);
				sanpham.setAnhSP(anhSP.getOriginalFilename());
				sanpham.setSoLuong(soLuong);
				sanpham.setDonGia(donGia);
				sanpham.setMoTa(moTa);
				
				
				session.update(sanpham);
				t.commit();	
				return "redirect:/admin/sanpham.htm";
			}
			catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Lỗi lưu file!");;
			}
			finally {
				session.close();
			}
		}
		return "redirect:/admin/sanpham.htm";
	}
	
	@RequestMapping("donhang") 
		public String showDonHang(ModelMap model) {
			Session session = factory.getCurrentSession();
			String hql = "FROM DonHang";
			Query query = session.createQuery(hql);
			List<SanPham> list = query.list();
			model.addAttribute("donhang",list);
			return "admin/donhang";
		}
	@Autowired
	Mailer mailer;
	@RequestMapping("xacnhan/{maDH}")
	public String xacNhan(ModelMap model,@PathVariable("maDH") int maDH) {	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		System.out.println(maDH);
		try {
			DonHang donhang = (DonHang)session.get(DonHang.class,maDH);		
			donhang.setTrangThai("Đã xác nhận");
			session.save(donhang);
			t.commit();
			mailer.thanhCong(donhang.getEmail());
		} catch(Exception ex) {
			t.rollback();
			model.addAttribute("message","loi gui mail");
		}
		session.close();
		return "redirect:/admin/donhang.htm";
	}
	

	@RequestMapping("huydon/{maDH}")
	public String huyDon(ModelMap model,@PathVariable("maDH") int maDH) {	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			DonHang donhang = (DonHang)session.get(DonHang.class,maDH);
			session.delete(donhang);
			t.commit();
			mailer.huyHang(donhang.getEmail());
		} catch(Exception ex) {
			t.rollback();
			model.addAttribute("message","loi gui mail");
		}
		
		session.close();
		return "redirect:/admin/donhang.htm";
	}
}
