<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		margin-top: 10em;
		margin-left: 10%;
		margin-bottom: 1em;
		
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
	h3,.thanh-toan {
		text-align: right;
		margin: 3em;
		margin-right: 30%;
		
	}
	#sl{
		width: 4em;
	}
	.SL{
	 width: 6em;
	}
	.thanh-toan{
	
	}
</style>
</head>
<body>
	<table>
		<tr>
            <th>Tên sản phẩm</th>
            <th>Ảnh sản phẩm</th>
			<th>Đơn giá</th>
			<th class="SL">Số lượng</th>
			<th>Giá tiền</th>
			<th>Chỉnh Sửa</th>
			
		</tr>
		<c:forEach var="item" items="${cart.items}" >
			<tr>
				<td><p>${item.sanPham.tenSP}</p></td>
				<td><img  class="anh-sp" src="/WebThaoDuoc/images/${item.sanPham.anhSP}" alt="Ảnh sản phẩm"></td>
				<td><p>${item.sanPham.donGia}</p></td>
				<td><input type="number" name="sl" id="sl" value="${item.soLuongMua}" min="0" width = "1em"></td>				
				<td><fmt:formatNumber type = "number" groupingUsed="true" value = "${item.tongGia}"/>₫</td>
				<td> 
				<%-- 	<a class="a-sp" href="cart-sua/${item.sanPham.maSP}.htm">Sửa</a>  --%>
					<a class="a-sp" href="cart-xoa/${item.sanPham.maSP}.htm">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h3> TỔNG TIỀN : <fmt:formatNumber type = "number" groupingUsed="true" value = "${cart.tongTien}"/>₫</h3>
	<div class ="thanh-toan">
		<a class="a-sp" href="thanh-toan.htm">Thanh toán</a> 
	    <a class="a-sp" href="reset-cart.htm">Xóa giỏ hàng</a>
	</div>
</body>
</html>