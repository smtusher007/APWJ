<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 10/13/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form method="post" action="register/v2">
        <label for="firstname">Firstname:</label>
        <input type="text" name="firstname" id="firstname"/>

        <br><br>

        <label for="lastname">Lastname:</label>
        <input type="text" name="lastname" id="lastname"/>

        <br><br>

        <input type="submit" value="Register">
    </form>

</body>
</html>
