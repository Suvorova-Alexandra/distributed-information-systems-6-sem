<%@ page import="DataAccess.models.pojo.Programmer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 27.02.2021
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show the high-paid programmer</title>
</head>
<body>
<% Programmer programmer = (Programmer) request.getAttribute("programmer");
    response.setContentType("text/html; charset=UTF8");
    if (programmer != null) {
        out.println("<p>The high-paid programmer </p>");
        out.println("<p> Name : " + programmer.getFIO() + "</p>");
        out.println("<p> Experience : " + programmer.getExperience() + "</p>");
        out.println("<p> Core technology : " + programmer.getCoreTechnology() + "</p>");
        out.println("<p> Salary : " + programmer.getSalary() + "</p>");

    } else {
        out.println("<p> \n The list of programmers is empty! </p>");
    }

%>
<div>
    <button onclick="location.href='/'">Return</button>
</div>
</body>
</html>
