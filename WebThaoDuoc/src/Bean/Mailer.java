package Bean;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailer")
public class Mailer {
	@Autowired
	JavaMailSender mailer;
	public void thanhCong(String to) {
		try {
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper heper = new MimeMessageHelper(mail,true,"utf-8");
			String from = "nguyenhieu191299@gmail.com";
			heper.setFrom(from,from);	
			heper.setTo(to);
			heper.setReplyTo(from,from);
			heper.setSubject("THÔNG BÁO ĐƠN HÀNG TỪ WEB THẢO DƯỢC");
			heper.setText( "Đơn hàng của bạn đã được xác nhận."
					+ "Cảm ơn bạn đã tin tưởng vào sản phẩm của chúng tôi :))",true);
			mailer.send(mail);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void huyHang(String to) {
		try {
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper heper = new MimeMessageHelper(mail,true,"utf-8");
			String from = "nguyenhieu191299@gmail.com";
			heper.setFrom(from,from);
			heper.setTo(to);
			heper.setReplyTo(from,from);
			heper.setSubject("THÔNG BÁO ĐƠN HÀNG TỪ WEB THẢO DƯỢC");
			heper.setText("Đơn hàng của bạn đã bị hủy."
					+ "Rất xin lỗi bạn về sự cố này :((",true);
			mailer.send(mail);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}

//String from ="nguyenhieu191299@gmail.com";
//String subject = "THÔNG BÁO ĐƠN HÀNG TỪ WEB THẢO DƯỢC";
//String body = "Đơn hàng của bạn đã được xác nhận."
//		+ "Cảm ơn bạn đã tin tưởng vào sản phẩm của chúng tôi :)))";


//String from ="nguyenhieu191299@gmail.com";
//String subject = "THÔNG BÁO ĐƠN HÀNG TỪ WEB THẢO DƯỢC";
//String body = "Đơn hàng của bạn đã bị hủy."
//			+ "Rất xin lỗi bạn về sự cố này :((";

