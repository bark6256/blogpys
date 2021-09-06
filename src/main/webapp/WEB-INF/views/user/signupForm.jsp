<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<h2>회원가입</h2>
<hr>

<form action="/signup" method="post">
  <div class="container">
    <label for="username"><b>아이디</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>비밀번호</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="email"><b>이메일</b></label>
    <input type="email" placeholder="Enter email" name="email" required>

	<button type="submit" class="btn btn-primary">회원가입</button>
</form>


<%@ include file="../include/footer.jsp"%>