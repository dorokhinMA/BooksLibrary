<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<spring:url value="/books/photo" var="bookImage"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${book.title}</title>
</head>
<body>

    <table>
        <tr>
            <td>Title</td>
            <td>${book.title}</td>
        </tr>
        <tr>
            <td>Image</td>
            <td><img src="${bookImage}/${book.id}/${book.author.id}"/></td>
        </tr>
        <tr>
            <td>Author</td>
            <td>${book.author.fio}</td>
        </tr>
        <tr>
            <td>Text</td>
            <td>${book.text}</td>
        </tr>
    </table>

<hr/>
</body>
</html>
