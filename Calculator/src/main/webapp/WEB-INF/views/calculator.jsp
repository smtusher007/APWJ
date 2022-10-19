<%--
  Created by IntelliJ IDEA.
  User: Refat
  Date: 18-Oct-22
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<center>
<table border="1">
    <tr>
        <td><h2>Calculator</h2></td>
    </tr>
    <tr>
        <td>
            <form class="alert" method="post" action="data/create">
                <input type="number" name="number1" id="number1" placeholder="Number1"/>

                <br><br>
                <input type="number" name="number2" id="number2" placeholder="Number2"/>

                <br><br>

                <center><input type="submit" value="calculate"></center>
            </form>
        </td>
    </tr>
    <tr>
        <td><h1>Result : ${result}</h1></td>
    </tr>
</table>
</center>
</body>
</html>
