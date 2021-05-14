package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Admin;

@Controller
@Transactional
public class LoginController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("login")
	public String showLogin(ModelMap model) {
		model.addAttribute("admin",new Admin());
		return "login";
	}
	
	@RequestMapping("logout")
	public String showLogin2(ModelMap model,HttpServletRequest request) {
		HttpSession session2 = request.getSession();
		session2.setAttribute("user",null); 
		return "redirect:/user/home.htm";
	}
	@RequestMapping("admin/quanli")
	public String login(@ModelAttribute("admin") Admin admin,ModelMap model,HttpServletRequest request) {
		Session session = factory.getCurrentSession();
		HttpSession session2 = request.getSession();
		String hql = " SELECT 1 FROM Admin WHERE TenDN = '" + admin.getTenDN() +"' AND Pass = '" + admin.getPass() + "'";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		if(query.uniqueResult() != null) {
			session2.setAttribute("user", "Admin");
			return "admin/quanli";
		} else {
			model.addAttribute("error",true);
			return "redirect:/login.htm";
		}	
	}
}
