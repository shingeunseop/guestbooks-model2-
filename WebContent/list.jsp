<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.GuestbooksVo" %>
<%@ page import="java.util.List" %>
<%
   
    List<GuestbooksVo> list=(List<GuestbooksVo>)request.getAttribute("list");
    %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td>
			<td><input type="text" name="ln" value=""></td>
			<td>비밀번호</td>
			<td><input type="password" name="ps" value=""></td>
		</tr>
		<tr>
			<td colspan=4><textarea type="content" name="co" value="" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			
		</tr>
	</table>
	</form>
	<br/>
	<%
	         for(GuestbooksVo vo :list){
	%>

	<table width=510 border=1>
		<tr>
			<td>[<%=vo.getNo() %>]</td>
			<td><%=vo.getName() %>></td>
			<td><%=vo.getReg_date() %></td>
			<td><a href="deleteform.jsp">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getContent() %></td>
		</tr>
	</table>
        <br/>
        
        <%
	         }
        %>
	
        <br/>
</body>
</html>