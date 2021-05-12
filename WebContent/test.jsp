<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String year=request.getParameter("year");
		String crimeType=request.getParameter("crimeType");
		
	%>
	<script>
		/*
		var selectedCrimeType= document.querySelector("#crimeType").value;
		var selectedYear=document.querySelector("#year").value;
		*/
		document.write(year+"\n");
		document.write(crimeType+"\n");
		
		
	</script>
</body>
</html>