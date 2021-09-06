<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp"%>
<br>
<h1>메인페이지</h1>
<hr>

<c:if test="${sessionScope.principal.username ne null }">
<h2>${sessionScope.principal.username}님 로그인</h2>
</c:if>
<br>
<%@ include file="include/footer.jsp"%>
