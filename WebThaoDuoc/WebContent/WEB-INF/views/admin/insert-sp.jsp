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
    <title>Thêm sản phẩm</title>
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
		.f-them{
			 margin-left: 14em;
		}
    </style>

</head>
<body>
	<h3>${param.message}</h3>
    <div id="insert-sp">
    	<h1>Thêm sản phẩm</h1>
        <form:form class="f-them" action="/WebThaoDuoc/admin/sanpham/them.htm" method="post" enctype="multipart/form-data">
            <div class="form-themsp">
                    <div class="row-item"><p>Tên sản phẩm</p><input type="text" name="tenSP" id="tenSP" required></div>
                    <div class="row-item"><p>Ảnh sản phẩm</p><input type="file" name="anhSP" id="anhSP" > <p>${param.message}</p></div> 
                    <div class="row-item"><p>Số lượng</p><input type="number" min="1" name="soLuong" id="soLuong" required></div>
                    <div class="row-item"><p>Đơn giá</p><input type="number" min="0" name="donGia" id="donGia" required></div>
                    <div class="row-item"><p>Mô tả</p><textarea cols="39" rows="8" name="moTa"></textarea></div>
            </div>
            <div class="btn-sp">
            	<input type="submit" value="Thêm" />
            	<input type="button" onclick="window.location.reload()" value="Nhập lại" />
            	<input type="button" onclick="location.href='/WebThaoDuoc/admin/sanpham.htm'"  value="Thoát" />
            </div>
            
	    </form:form>
    </div>
</body>
</html>