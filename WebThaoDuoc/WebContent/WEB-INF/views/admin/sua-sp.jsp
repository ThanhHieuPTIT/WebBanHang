
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="${pageContext.servletContext.contextPath}"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa sản phẩm</title>
    <style>
    	#insert-sp h1{
    		text-align: center;
    		padding: 1.5em;
    	}
    	
        .form-themsp .row-item{
        	display: flex;
  	     	margin: 1em;
        }
        
        .form-themsp .row-item p{
        	    width: 10em;
        }
        
        .form-themsp .input-sanpham{
        	display: flex;
        	flex-direction: column;
        }
        
        .form-themsp input{
        	width: 22em;
        }
		
		.btn-sp{
			margin-left: 10em;
		}
		.btn-sp input{
			padding: 3px;
			margin: 2em
		}
		#sanpham {
			margin-left: 20%;
		}
    </style>

</head>
<body>
	<h3>${param.message}</h3>
    <div id="insert-sp">
    	<h1>Sửa sản phẩm</h1>
        <form:form action="/WebThaoDuoc/admin/sanpham/sua.htm" method="post" enctype="multipart/form-data" modelAttribute="sanpham">
            <div class="form-themsp">
            		<div class="row-item"><p>Mã sản phẩm</p><input type="text" name="maSP" id="maSP" value="${sanpham.maSP}" readonly></div>
                    <div class="row-item"><p>Tên sản phẩm</p><input type="text" name="tenSP" id="tenSP" value="${sanpham.tenSP}" required></div> 
                    <div class="row-item"><p>Ảnh sản phẩm</p><input type="file" name="anhSP" id="anhSP"> <p>${param.message}</p></div>     
                    <div class="row-item"><p>Số lượng</p><input type="number" min="0" name="soLuong" id="soLuong" value="${sanpham.soLuong}" required></div>
                    <div class="row-item"><p>Đơn giá</p><input type="number" min="0" name="donGia" id="donGia" value="${sanpham.donGia}"></div>
                    <div class="row-item"><p>Mô tả</p><textarea cols="39" rows="8" name="moTa" value="${sanpham.moTa}"></textarea></div>
            </div>
            <div class="btn-sp">
            	<input type="submit" value="Lưu" />
            	<input type="button" onclick="window.location.reload()" value="Nhập lại" />
            	<input type="button" onclick="location.href='/WebThaoDuoc/admin/sanpham.htm'"  value="Thoát" />
            </div>
            
	    </form:form>
    </div>
</body>
</html>