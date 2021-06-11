<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Change</title>
</head>
<body>
Yes or no?
<p th:text="${tag.getName()}">VALUE</p>
<p th:text="${tag.getId()}">VALUE</p>
and why?
<form th:method="DELETE" th:action="@{/tag/{id}(id=${tag.getId()})}">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>