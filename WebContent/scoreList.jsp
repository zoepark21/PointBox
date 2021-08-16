<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dto.PointboxDTO" %>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Class</th>
<th>Name</th>
<th>Score</th>
</tr>
<% ArrayList<PointboxDTO> List = (ArrayList<PointboxDTO>)request.getAttribute("List");
	for(int i =0; i<List.size(); i++) {%>
	<tr>
	<td><%=List.get(i).getStclass() %></td>
	<td><%=List.get(i).getStname() %></td>
	<td><%=List.get(i).getScore() %></td>
	</tr>
	<%} %>

<button>+</button>
<button>-</button>
</table>
</body>
</html>