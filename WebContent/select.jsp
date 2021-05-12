<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	Connection conn=null;

	String url="jdbc:mysql://localhost:3306/project?characterEncoding=euckr";
	String user="root";
	String password="1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(url, user, password);
	%>
	
	<table width="300"	 border="1">
		<tr>
			<th>아이디 </th>
			<th>년도</th>
			<th>지역</th>
			<th>살인</th>
			<th>성폭행 </th>
			<th>구타</th>
			<th>주거침입</th>
		</tr>
		<%
			ResultSet rs=null;
			Statement stmt=null;
			
			try{
				String sql="select * from crimes";
				stmt=conn.createStatement(); 
				rs=stmt.executeQuery(sql);
				
				while(rs.next()){
					String cid=rs.getString("cid");
					int year=rs.getInt("year");
					String region=rs.getString("region");
					int murder=rs.getInt("murder");
					int sex_violence=rs.getInt("sex_violence");
					int assault=rs.getInt("assault");
					int intrud=rs.getInt("intrud");
			%>
			<tr>
				<td><%=cid %></td>
				<td><%=year %></td>
				<td><%=region %></td>
				<td><%=murder %></td>
				<td><%=sex_violence %></td>
				<td><%=assault %></td>
				<td><%=intrud %></td>
			</tr>
			<%
				}	
				out.println("테이블 삽입 성공<br>");
			}catch(SQLException e){
				out.println("테이블 삽입 실패<br>");
			}finally{
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
				if(conn!=null)	conn.close();
			}
		%>
	</table>
	
	
</body>
</html>