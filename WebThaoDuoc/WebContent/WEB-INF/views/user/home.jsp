<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>thaoduoctaybac</title>
	<link rel="stylesheet" href="/WebThaoDuoc/assets/content.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
</head>
<body>
	<div id="content">
        <c:forEach var="sp" items="${sanpham}">
        	<div class="sp-item">
        		<img  class="anh-sp" src="/WebThaoDuoc/images/${sp.anhSP}" alt="Ảnh sản phẩm">            	
            	<h3 class="ten-sp">${sp.tenSP}</h3>
            	<h5 class="gia-sp"><fmt:formatNumber type = "number" groupingUsed="true" value = "${sp.donGia}"/>₫/1kg</h5> <hr>
            	<div>
					<c:choose>
            			<c:when test="${sp.soLuong == 0}">
            				<h3 class="ten-sp btn-dh" text-align = "center">Hết hàng</h3>
            			</c:when>
            			<c:when test="${sp.soLuong > 0}">
            				<a class="ten-sp btn-dh hdne" href="cart-them/${sp.maSP}.htm">Đặt hàng</a>
            			</c:when>
            		</c:choose>
            		
            	</div>
            	
        	</div>
        </c:forEach>
    </div>
</body>
</html>