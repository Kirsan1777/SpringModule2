<html lang="en" xmlns:th="http://www.thymeleaf.org">
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
            <td><p th:text="${gift.getName()}"></p></td>
            <td><p th:text="${gift.getCreateDate()}"></td>
            <td><p th:text="${gift.getDuration()}"></td>
            <td><p th:text="${gift.getDescription()}"></td>
            <td><p th:text="${gift.getPrice()}"></td>
            <td><p th:text="${gift.getLastUpdateDate()}"></td>

        </tr>
    </table>
</div>
<div align="center">
<form th:method="DELETE" th:action="@{/certificate/{id}(id=${gift.getId()})}">
    <input type="submit" value="Delete"/>
</form>
</div>
<div align="center">
    <form th:method="PATCH" th:action="@{/certificate/{id}(id=${gift.getId()})}" th:object="${gift}">
        <table>
            <tr>
                <td><label for="name">Enter name: </label>
                <td><input type="text" th:field="*{name}" id="name"/>
            </tr>
            <tr>
                <td><label for="description">Enter description: </label>
                <td><input type="text" th:field="*{description}" id="description"/>
            </tr>
            <tr>
                <td><label for="duration">Enter duration: </label>
                <td><input type="text" th:field="*{duration}" id="duration"/>
            </tr>
            <tr>
                <td><label for="price">Enter price: </label>
                <td><input type="text" th:field="*{price}" id="price"/>
            </tr>
        </table>
        <input type="submit" value="Update!"/>
    </form>
</div>

<div align="center">
    <form method="POST" action="addTagToGift">
        <table>
            <td><input type="hidden" name="idTag" th:value="${gift.getId()}"/></td>
            <td><input type="text" name="newTag"/></td>
        </table>
        <input type="submit" value="Add Tag"/>
    </form>
</div>
</body>
</html>
