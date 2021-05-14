<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/WebThaoDuoc/assets/login.css">
</head>
<body>
<div id="login">
    <form action="admin/quanli.htm" method="POST" modelAttribute="admmin">
        <div class="imgcontainer">
          <img src="/WebThaoDuoc/images/img_avatar2.png" alt="Avatar" class="avatar">
        </div>
      
        <div class="container">
          <label for="tenDN"><b>Tên đăng nhập</b></label>
          <input type="text" placeholder="Enter Username" name="tenDN" path="tenDN" required>
      
          <label for="pass"><b>Mật khẩu</b></label>
          <input type="password" placeholder="Enter Password" name="pass" path="pass" required>
              
          <button type="submit">Đăng nhập</button>
          <!-- <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
          </label> -->
        </div>
      
        <div class="container" style="background-color:#f1f1f1">
        	<a class= "cancelbtn" href="/WebThaoDuoc/user/home.htm">Thoát</a>
        	<c:if test="${param['error']}"><span class="psw">Kiểm tra lại tên đăng nhập hoặc mật khẩu</span></c:if>
          <!-- <span class="psw">Kiểm tra lại tên đăng nhập hoặc mật khẩu</span> -->
        </div>
             <%--  <c:if test="${param['error']}"><span class="psw">Kiểm tra lại tên đăng nhập hoặc mật khẩu</span></c:if> --%>
    </form>
</div>
</body>
</html>