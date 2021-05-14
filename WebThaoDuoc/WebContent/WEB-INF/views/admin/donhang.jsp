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
			<th>Mã đơn hàng</th>
			<th>Tên khách hàng</th>
			<th>SDT</th>
			<th>Email</th>
			<th>Ngày đặt hàng</th>
			<th>Địa chỉ</th>
			<th>Tổng tiền</th>	
			<th>Trạng thái</th>
			<th> </th>
		</tr>
		<c:forEach var="dh" items="${donhang}">
			<tr>
				<td>${dh.maDH}</td>
				<td>${dh.tenKH}</td>
				<td>${dh.sDT}</td>
				<td>${dh.email}</td>
				<td>${dh.ngayDatHang}</td>			
				<td>${dh.diaChi}</td>
				<td>${dh.tongTien}</td>
				<td>${dh.trangThai}</td>
				<td> 
					
					<a class="a-sp" href="xacnhan/${dh.maDH}.htm">Xác nhận</a>
					<a class="a-sp" href="huydon/${dh.maDH}.htm">Hủy</a>
				</td>
		</tr>
</c:forEach>
</table>
	
</body>
</html>