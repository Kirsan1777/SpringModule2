<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div th:each="gift : ${gifts}">
    <a th:href="@{/certificate/{id}(id=${gift.getId()})}"
       th:text="${gift.getName()}"
    ></a>

    <p th:text="${gift.getDescription()}"></p>
    <p th:text="${gift.getPrice()}"></p>
    <p th:text="${gift.getCreateDate()}"></p>
</div>

<form th:method="POST" th:action="@{/certificate}" th:object="${gift}">
    <label for="name">Enter name: </label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <label for="description">Enter description: </label>
    <input type="text" th:field="*{description}" id="description"/>
    <br/>
    <label for="price">Enter price: </label>
    <input type="number" min="0" max="500" th:field="*{price}" id="price"/>
    <br/>
    <input type="submit" value="Create"/>
</form>

Concatenated table!
<div th:each="table : ${tables}">
    <p th:text="${table.getTagName()}"></p>
    <p th:text="${table.getGiftName()}"></p>
    <p th:text="${table.getCreateDate()}"></p>
</div>

</body>
</html>