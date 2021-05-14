<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="/WebThaoDuoc/assets/header.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/WebThaoDuoc/assets/footer.css">
    <link rel="stylesheet" href="/WebThaoDuoc/assets/themify-icons/themify-icons.css"> 
    <style>
    	html{
    		scroll-behavior: smoth;
    	}
    </style>
</head>

<body>	
	 <div id="header">
        <div class="nav">
            <ul class="nav-list">     	
                <li><a class="nav-item" href="/WebThaoDuoc/user/home.htm">Trang chủ</a></li>
                <li><a class="nav-item" href="#content">Sản phẩm</a></li>
                <li><a class="nav-item" href="#footer">Liên hệ</a></li>
            </ul>
            <ul class="nav-list1">
                <li> <i class="ti-shopping-cart"></i><a class="nav-item" href="/WebThaoDuoc/user/cart-show.htm">Giỏ hàng</a></li>
            </ul>
        </div>
    </div>
    
	<article>
		<jsp:include page="${param.view}"></jsp:include>
	</article>
	
    <div id="footer">
        <div class="ft-left">
            <h1 class="ft-Tieude">Thảo dược Tây Bắc</h1>
            <h4 class="ft-heading">Chuyên bán lẻ các loại thảo dược và nhận gửi hàng toàn quốc</h4>
        </div>
        <div class="ft-right">
            <div class="lienhe">
                <h1 class="lienhe">Thông tin liên hệ</h1>
                <p><i class="ti-location-pin"></i>Địa chỉ: Thôn Kiều - Tiên Tân - Tp.Phủ Lý - Hà Nam</p>
                <p><i class="ti-mobile"></i>SDT: 0983104570 </p>
                <p><i class="ti-email"></i>Email: thaoduoctaybac@gmail.com</p>
            </div>
            <div class="social">
                <a href=""><i class="ti-facebook"></i></a>
                <a href=""><i class="ti-instagram"></i></a>
                <a href="https://www.youtube.com/channel/UCq8lxrtHulMxpzjkVEzjx7w"><i class="ti-youtube"></i></a>
                <a href=""><i class="ti-pinterest"></i></a>
                <a href=""><i class="ti-twitter"></i></a>
                <a href=""><i class="ti-linkedin"></i></a>
            </div>
        </div>
    </div>
</body>
</html>