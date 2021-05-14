<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 80%;
		margin-top: 3em;
		margin-left: 10%;
	}
	th, td {
    	margin: 0;
    	line-height: 2em;
    	border: 2px solid #71bdaf;
    	text-align: center;
    }
	th {
		background-color: cyan;
	}
	body>a{
	}
	.a-sp {
		border-radius: 15%;
    	margin: 0 0.3em;
	    text-decoration: none;
	    padding: 0.4em;
	    background-color: #c0ce34;
	    color: #1d282d;
	}
	.a-sp:hover{
		background-color: #adcfd4;
	}
	
	.anh-sp{
		width: 4em;
    	vertical-align:middle;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>Mã sản phẩm</th>
			<th>Tên sản phẩm</th>
			<th>Ảnh sản phẩm</th>
			<th>Số lượng</th>
			<th>Đơn giá</th>
			<th>Mô tả</th>
			<th><a class="a-sp a-them" href="sanpham/show-them.htm">Thêm mới</a></th>
		</tr>
		<c:forEach var="sp" items="${sanpham}">
			<tr>
				<td>${sp.maSP}</td>
				<td>${sp.tenSP}</td>
				<td><img  class="anh-sp" src="/WebThaoDuoc/images/${sp.anhSP}" alt="Ảnh sản phẩm"></td>
				<td>${sp.soLuong}</td>
				<td><fmt:formatNumber type = "number" groupingUsed="true" value = "${sp.donGia}"/></td>
				<td>${sp.moTa}</td>
				<td> 
					<a class="a-sp" href="sanpham/sua/${sp.maSP}.htm">Sửa</a>
					<a class="a-sp" href="sanpham/delete/${sp.maSP}.htm">Xóa</a>
				</td>
</tr>
</c:forEach>
</table>
</body>
</html>