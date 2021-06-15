<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>

<div align="center">
    <h1>Gift</h1>
    <table border="1">
        <th>Gift Name</th>
        <th>Create Date</th>
        <th>Duration</th>
        <th>Description</th>
        <th>Price</th>
        <th>Last Update Date</th>
            <tr>
                <td ><p th:text="${gift.getName()}"></p></td>
                <td ><p th:text="${gift.getCreateDate()}"></td>
                <td ><p th:text="${gift.getDuration()}"></td>
                <td ><p th:text="${gift.getDescription()}"></td>
                <td ><p th:text="${gift.getPrice()}"></td>
                <td ><p th:text="${gift.getLastUpdateDate()}"></td>

            </tr>
    </table>
</div>

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

<form method="POST" action="addTagToGift">
    <td><input type="hidden" name="idTag" th:value="${gift.getId()}"/></td>
    <td><input type="text" name="newTag"/></td>
    <input type="submit" value="Submit" />
</form>

</body>
</html>
