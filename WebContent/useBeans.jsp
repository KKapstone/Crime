<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.util.ArrayList, com.dao.Crimes"%>

<jsp:useBean id="crimeDB" class="com.dao.CrimesDB" scope="page" />

        <%
            ArrayList<Crimes> list = crimeDB.getCrimeList();

            int counter = list.size();
 			//cnt는 확인
            if (counter > 0) {
            	for(Crimes cr:list){
            		out.print(cr.getYear());
            	}
            }
        %>
        
</body>
</html>