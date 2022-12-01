
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>

<h1>Hello</h1>

<c:out value="${student.firstname}" />
<br><br>
<c:out value="${student.lastname}" />

<hr>

<p>Welcome, ${user.email} ${user.password}</p>

</body>
</html>
