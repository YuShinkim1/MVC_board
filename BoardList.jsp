<%@page import="dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
	ArrayList<BoardDto> listBoard = (ArrayList<BoardDto>) request.getAttribute("listBoard");
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="js/jquery-3.7.0.min.js"></script>
	<script>
		$(function() {
			/* $("#btn_write").click(function() {
				location.href = "Ex13BoardWrite.jsp";
			}); */
			$("tr").click(function() {
				let bno = $(this).find(".bno").text();
				location.href = "Controller?command=board_detail&bno=" + bno;
			});
		});
	</script>
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
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
		<%
			for(BoardDto dto : listBoard) {
		%>
		<tr>
			<td class="bno"><%=dto.getBno() %></td>
			<td><%=dto.getTitle() %></td>
			<td><%=dto.getWriter() %></td>
			<td><%=dto.getWritedate() %></td>
		</tr>
		<%
			}
		%>
	</table>	
	
	<div>
		<button id="btn_write">글쓰기</button>
	</div>
	
</body>
</html>
