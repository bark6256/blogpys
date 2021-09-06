<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
ul.menu {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

ul.menu li {
  float: left;
}

ul.menu li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

ul.menu li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}

input[type=text], input[type=password], input[type=email] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
.container {
  padding: 16px;
}
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}
footer {
  text-align: center;
  padding: 3px;
  background-color: DarkSalmon;
  color: white;
}
</style>
</head>
<body>

<ul class="menu">
  <li><a class="active" href="/home">메인</a></li>
  <c:if test="${sessionScope.principal.username eq null}">
  <li><a href="/loginForm">로그인</a></li>
  <li><a href="/signupForm">회원가입</a></li>
  </c:if>
  <c:if test="${sessionScope.principal.username ne null}">
  <li><a href="#">글쓰기</a></li>
  <li><a href="/userInfoForm">회원정보</a></li>
  <li><a href="/logout">로그아웃</a></li>
  </c:if>
  
</ul>