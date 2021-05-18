<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h3>Customer's information</h3>
<form action="ShowCustomerServlet" method="post">

    <label> Customer's number:
        <input name="number" type="number">
    </label>
    <label> Credit Limit:
        <input name="creditLimit" type="number">
    </label>
    <input name="go" type="submit" value="Show">
</form>
</body>
</html>
