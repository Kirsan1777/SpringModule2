<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>
<p th:text="${gift.getName()}">VALUE</p>
<p th:text="${gift.getId()}">VALUE</p>
<p th:text="${gift.getDescription()}">VALUE</p>

<form th:method="DELETE" th:action="@{/certificate/{id}(id=${gift.getId()})}">
    <input type="submit" value="Delete"/>
</form>

<form th:method="PATCH" th:action="@{/certificate/{id}(id=${gift.getId()})}" th:object="${gift}">
    <label for="name">Enter name: </label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <label for="description">Enter description: </label>
    <input type="text" th:field="*{description}" id="description"/>
    <br/>
    <input type="submit" value="Update!"/>
</form>

</body>
</html>
