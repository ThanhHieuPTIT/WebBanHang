<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="/WebThaoDuoc/assets/admin-layout.css">
    <link rel="stylesheet" href="/WebThaoDuoc/assets/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
</head>
<body>
    <div id="layout">
        <div class="nav">
            <p class="td">Quản lí trang web</p>
            <ul class="nav-list">
                <li class="nav-item"><a href="/WebThaoDuoc/admin/sanpham.htm">Sản Phẩm</a></li>
                <li class="nav-item"><a href="/WebThaoDuoc/admin/donhang.htm">Đơn hàng</a></li>
                <li class="nav-item"><a href="/WebThaoDuoc/logout.htm">Đăng xuất</a></li>
            </ul>
        </div>
        <div class="content">
			<article>
				<jsp:include page="${param.view}"></jsp:include>
			</article>
        </div>
    </div>
</body>
</html>