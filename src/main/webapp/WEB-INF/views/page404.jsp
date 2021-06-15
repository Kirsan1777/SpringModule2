<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 14.06.2021
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>Error 404</title>
</head>
<body>
<h1>Error 404!</h1>
<p>Error message is <p th:text="${exception}">"</p>
<button class="btn btn-primary" onclick="history.back()">Back to previous page</button>
</body>
</html>