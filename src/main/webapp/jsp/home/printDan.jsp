<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
int dan= Integer.parseInt(request.getParameter("dan"));
int limit= Integer.parseInt(request.getParameter("limit"));
String color = request.getParameter("color");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>😊구구단 출력😊</title>
<style>.color {color: <%=color%>}</style>
</head>
<body class ="color">

<h1>== <%=dan%>단 ==</h1>

<section> 

<%for(int i = 1; i <= limit; i++){%>
	<div>
	<%=dan%> * <%=i%> = <%=dan * i%>
	</div>
	<%}%>
	
</section>



</body>
</html>







