<%@ page import="DataAccess.models.pojo.Programmer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 27.02.2021
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all programmers by position

        <%
            String position = (String) request.getAttribute("position");
            out.println(position);
        %>
    </title>
</head>
<body>
<% ArrayList<Programmer> filteredProgrammers = (ArrayList<Programmer>) request.getAttribute("filteredProgrammers");
    if (filteredProgrammers.size() != 0) {

        if (filteredProgrammers.isEmpty()) {
            out.println("<p> \n There are no programmers with such position! </p>");
        }
        for (int i = 0; i < filteredProgrammers.size(); i++) {
            out.println("<p>Programmer " + (i + 1) + "</p>");
            out.println("<p> Name : " + filteredProgrammers.get(i).getFIO() + "</p>");
            out.println("<p> Experience : " + filteredProgrammers.get(i).getExperience() + "</p>");
            out.println("<p> Core technology : " + filteredProgrammers.get(i).getCoreTechnology() + "</p>");
            out.println("<p> Salary : " + filteredProgrammers.get(i).getSalary() + "</p>");
            out.println("<p> ------------------------------------------------");
        }

    } else {
        out.println("<p> \n The list of programmers is empty! </p>");
    }
%>


<div>
    <button onclick="location.href='/'">Return</button>
</div>
</body>
</html>
