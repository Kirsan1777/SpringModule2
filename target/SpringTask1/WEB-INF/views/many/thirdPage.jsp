<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<div align="center">
    <h1>Tag with gifts List</h1>
    <table border="1">
        <th>Tag Name</th>
        <th>Cert Name</th>
        <th>Create Date</th>
        <th>Duration</th>
        <th>Description</th>
        <th>Price</th>
        <th>Last Update Date</th>
            <div th:each="gift : ${tables}">
            <tr>
                <td ><p th:text="${gift.getTagName()}" ></td>
                <td ><p th:text="${gift.getGiftName()}"></td>
                <td ><p th:text="${gift.getCreateDate()}"></td>
                <td ><p th:text="${gift.getDuration()}"></td>
                <td ><p th:text="${gift.getDescription()}"></td>
                <td ><p th:text="${gift.getPrice()}"></td>
                <td ><p th:text="${gift.getLastUpdateDate()}"></td>

            </tr>
            </div>
    </table>
</div>


<div align="center">
Sort by:
<a th:href="@{/many/sortDateDesc}">Date DESC</a>
<a th:href="@{/many/sortDateAsc}">Date ASC</a>

<a th:href="@{/many/sortTagNameDesc}">Tag name DESC</a>
<a th:href="@{/many/sortTagNameAsc}">Tag name ASC</a>
</div>


<form th:method="GET" th:action="@{/many/findByAllParam}">
<div align="center">
    Enter tag name:
    <input type="text" name="nameTag"/>
    <br/>
    Enter part of name:
    <input type="text" name="nameGift"/>
    <tr>
        <td>
            <label>Find by :</label>
        </td>
        <td>
            <select name="chooseType">
                <option value="" label="Choose one"/>
                <option value="c.name" label="Name"/>
                <option value="c.description" label="Description"/>
            </select>
        </td>
    </tr>
    <br/>
    <tr>
        <td>
            <label>Column for sort:</label>
        </td>
        <td>
            <select name="orderBy">
                <option value="" label="Choose one"/>
                <option value="c.name" label="Name"/>
                <option value="c.create_date" label="Date"/>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <label>ASC/DESC:</label>
        </td>
        <td>
            <select name="typeSort">
                <option value="ASC" label="ASC"/>
                <option value="DESC" label="DESC"/>
            </select>
        </td>
    </tr>
    <input type="submit" name="submit"/>
</div>
</form>
</body>
</html>
