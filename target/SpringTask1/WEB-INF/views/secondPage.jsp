<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div th:each="gift : ${gifts}">
    <a th:href="@{/gifts/{id}(id=${gift.getId()})}"
       th:text="${gift.getName()}"
    ></a>

    <p th:text="${gift.getDescription()}"></p>
    <p th:text="${gift.getPrice()}"></p>
    <p th:text="${gift.getCreateDate()}"></p>

</div>
</body>
</html>