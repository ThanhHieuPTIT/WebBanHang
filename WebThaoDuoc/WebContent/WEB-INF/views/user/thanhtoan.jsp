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
    <title>Thông tin thanh toán</title>
    <style>
        #insert-sp{
            margin-left: 25%;
            height: 700px;
        }
    	h1 {
    		text-align: center;
            padding: 1.5em;   
            margin-top: 4em;   
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
            width: 28em;
            height: 1.5em;
        }
		
		.btn-tt input{
            margin-top: 1em;
            margin-left: 8em;
            margin-right: 3em ;
		}
		.btn-sp input{
			padding: 3px;
			margin: 2em;
		}
		#sanpham {
			margin-left: 20%;
		}
		h4{
			text-align: center;
		}
    </style>

</head>
<body>
    
    <h1>Thông tin thanh toán</h1>
	    <h4>${message}</h4>
    <div id="insert-sp">
        <form:form action="/WebThaoDuoc/user/end-thanh-toan.htm" method="post" modelAttribute="donhang">
            <div class="form-themsp">
                    <div class="row-item"><p>Tên khách hàng</p><input type="text" name="tenKH" id="tenKH" required></div>
                    <div class="row-item"><p>Địa chỉ</p><input type="text" name="diaChi" id="diaChi" required></div> 
                    <div class="row-item"><p>Số điện thoại</p><input type="text" name="sDT" id="sDT" required></div>
                    <div class="row-item"><p>Email</p><input type="email" name="email" id="email" required></div>
            </div>
            <div class="btn-tt">
            	<input type="submit" value="Hoàn tất thanh toán" />
            	<input type="button" onclick="window.location.reload()" value="Nhập lại" />
            	<input type="button" onclick="location.href='/WebThaoDuoc/user/cart-show.htm'"  value="Thoát" />
            </div>
	    </form:form>
    </div>
	
</body>
</html>