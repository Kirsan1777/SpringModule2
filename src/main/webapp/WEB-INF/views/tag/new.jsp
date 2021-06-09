<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>

<form th:method="POST" th:action="@{/tag}" th:object="${tag}">
    <label for="name">Enter name: </label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <input type="submit" value="Create!"/>
</form>

</body>
</html>
