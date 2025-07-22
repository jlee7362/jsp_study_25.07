<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow"); 
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
<a href="../home/main">메인으로 이동</a><br>
<a href="../article/list">리스트로 이동</a>

	<h2><%=articleRow.get("id") %>번 글 수정하기</h2>
	
	<form action="doModify" method="post">
		<input type="hidden" name= "id" value=<%=articleRow.get("id")%> >
		<div>제목 : <input type="text" name="title" value=<%=articleRow.get("title")%>></div>
		<div>내용 : <input style="width:350px; height:300px;"type="text" name="body" value=<%=articleRow.get("body")%>></div>
		<button type="submit">글 수정</button>
	</form>

</body>
</html>