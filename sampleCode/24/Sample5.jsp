<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String carname = request.getParameter("cars");
%>

<html>
<head>
<title><%= carname %></title>
</head>
<body>
<div style="text-align: center;">
<h2><%= carname %></h2>
<%= carname %>
のお買い上げありがとうございました。<br/>
</div>
</body>
</html>
