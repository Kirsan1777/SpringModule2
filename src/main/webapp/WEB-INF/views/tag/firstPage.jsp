<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div th:each="tag : ${tags}">
    <a th:href="@{/tag/{id}(id=${tag.getId()})}"
       th:text="${tag.getName()}">user</a>
</div>

<form th:method="POST" th:action="@{/tag}" th:object="${tag}">
    <label for="name">Enter name: </label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <input type="submit" value="Create"/>
</form>

</body>
</html>