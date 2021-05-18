<%@ page import="CustomersTask.BusinessLogicModels.pojo.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02.03.2021
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer page
    </title>
</head>
<body>
<%
    String result = (String) request.getAttribute("result");
    String resultProcedure = (String) request.getAttribute("resultProcedure");
    out.println("<h3>Customer by number</h3>");
    if (result == "OK") {
        String fullName = (String) request.getAttribute("name");

        String phone = (String) request.getAttribute("phone");
        double creditLimit = (double) request.getAttribute("creditLimit");
        out.println("<p>Customer: </p>");
        out.println("<p> Name : " + fullName + "</p>");
        out.println("<p> Phone : " + phone + "</p>");
        out.println("<p> Credit Limit : " + creditLimit + "</p>");

    } else if (result == "NOT OK") {
        out.println("<p>There are no customers with such number!  </p>");
    } else {
        out.println("<p>Complete the Customer Number filed!  </p>");
    }


    out.println("<h3>Stored PROCEDURE</h3>");
    if (resultProcedure == "OK") {

        List<Customer> customers = (List<Customer>) request.getAttribute("customers");
        for (int i = 0; i < customers.size(); i++){
            out.println("<p>Customer:"+(i+1)+" </p>");
            out.println("<p> Name : " + customers.get(i).getFullName() + "</p>");
            out.println("<p> Phone : " + customers.get(i).getPhone() + "</p>");
            out.println("<p> Credit Limit : " + customers.get(i).getCreditLimit() + "</p>");
            out.println("<p>----------------------------------------------------------</p>");

        }
    } else if (resultProcedure == "NOT OK") {
        out.println("<p>There are no customers with such credit limit!  </p>");
    } else {
        out.println("<p>Complete the Credit Limit filed!  </p>");
    }


%>
<div>
    <button onclick="location.href='/lab3'">Return</button>
</div>
</body>
</html>
