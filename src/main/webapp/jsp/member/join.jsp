<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member join</title>
</head>
<body>

<a href="../home/main">메인으로 이동</a>

	<h2>회원가입</h2>
	<form action="doJoin" method="post">
		<div>아이디 : <input type="text" name="loginId" placeholder="아이디 입력"/></div>
		<div>비밀번호 : <input type="text" name="loginPw" placeholder="비밀번호 입력"/></div>
		<div>비밀번호 확인: <input type="text" name="loginPwConfirm" placeholder="비밀번호 확인"/></div>
		<div>이름: <input type="text" name="name" placeholder="이름"/></div>
		<button type="submit">가입</button>
	</form>

</body>
</html>