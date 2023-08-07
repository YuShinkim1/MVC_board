<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="dto.BoardDto"%>
<%@ page import="dao.BoardDao"%>

<%
	BoardDto dto = (BoardDto)request.getAttribute("boardDto");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="js/jquery-3.7.0.min.js"></script>
	<style>
		table {
			border-collapse: collapse;  /* 한 줄의 경계선으로 만듦. */
		}
		th,td {
			border: 1px solid grey;
			padding: 8px;
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td><%=dto.getBno() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=dto.getContent() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
	</table>
	<button onclick="location.href='Controller?command=board_list';">목록으로</button>
	
	
</body>
</html>







