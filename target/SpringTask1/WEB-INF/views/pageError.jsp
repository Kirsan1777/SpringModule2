<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 15.06.2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<h1>Error!</h1>
<p>Error message is <p th:text="${exception.getMessage()}">"</p>
<button class="btn btn-primary" onclick="history.back()">Back to previous page</button>
</body>
</html>
