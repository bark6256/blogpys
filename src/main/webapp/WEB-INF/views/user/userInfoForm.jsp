<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

<h2>회원 정보</h2>
<ul class="list-group">
  <li class="list-group-item">아이디 : ${sessionScope.principal.username}</li>
  <li class="list-group-item">이메일 : ${sessionScope.principal.email}</li>
</ul>
<%@ include file="../include/footer.jsp"%>
