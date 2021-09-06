<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<h2>로그인</h2>
<hr>

<form action="/login" method="post">
  <div class="container">
    <label for="username"><b>아이디</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>비밀번호</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

	<button type="submit" class="btn btn-primary">로그인</button>
</form>


<%@ include file="../include/footer.jsp"%>