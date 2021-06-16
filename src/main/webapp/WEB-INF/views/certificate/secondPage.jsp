<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Gifts list</h1>
    <table border="1">
        <th>Gift Name</th>
        <th>Create Date</th>
        <th>Duration</th>
        <th>Description</th>
        <th>Price</th>
        <th>Last Update Date</th>
        <div th:each="gift : ${gifts}">
            <tr>
                <td ><a th:href="@{/certificate/{id}(id=${gift.getId()})}"
                        th:text="${gift.getName()}"></a>
                </td>
                <td ><p th:text="${gift.getCreateDate()}"></td>
                <td ><p th:text="${gift.getDuration()}"></td>
                <td ><p th:text="${gift.getDescription()}"></td>
                <td ><p th:text="${gift.getPrice()}"></td>
                <td ><p th:text="${gift.getLastUpdateDate()}"></td>

            </tr>
        </div>
    </table>
</div>

<form th:method="POST" th:action="@{/certificate/add}" th:object="${gift}">
    <label for="name">Enter name: </label>
    <input type="text" required th:field="*{name}" id="name"/>
    <br/>
    <label for="description">Enter description: </label>
    <input type="text" th:field="*{description}" id="description"/>
    <br/>
    <label for="price">Enter price: </label>
    <input type="number" min="0" max="500" th:field="*{price}" id="price"/>
    <br/>
    <label for="duration">Enter duration: </label>
    <input type="number" min="0" max="500" th:field="*{duration}" id="duration"/>
    <br/>
    <input type="submit" value="Create"/>
</form>

</body>
</html>