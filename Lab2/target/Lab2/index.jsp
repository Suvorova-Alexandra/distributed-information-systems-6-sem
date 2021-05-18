<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h3>The programmer and his technology, depending on the entered position: </h3>
<form action="ShowProgrammerByPositionServlet " method="post">
    Position:
    <select name="category">
        <option value="Junior">Junior</option>
        <option value="Middle">Middle</option>
        <option value="Senior">Senior</option>
        <option value="Lead">Lead</option>
    </select>
    <input name="go" type="submit" value="Show">
</form>
<h3>The highest paid programmer: </h3>
<form action="ShowTheHighPaidProgrammerServlet " method="post">
    <input name="go" type="submit" value="Show">
</form>

</body>
</html>
