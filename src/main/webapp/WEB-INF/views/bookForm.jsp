<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new book</title>
</head>
<body>

<%--<form action="${pageContext.request.contextPath}/books/add" method="post" enctype="multipart/form-data" id="newBook">--%>

<%--<c:if test="${updatingBook ne null}">--%>
<%--<c:set var="id" value="${updatingBook.id}"/>--%>
<%--</c:if>--%>
<%--<input type="hidden" name="id" value="${id}">--%>

<%--<label>Title:</label>--%>

<%--<label><textarea rows="10" cols="45" name="title" required><c:out value="${updatingBook.title}"/></textarea></label>--%>

<%--<br/>--%>
<%--<br/>--%>
<%--<br/>--%>

<%--<label>Обложка:</label>--%>

<%--<label><input type="file" name="image"></label>--%>

<%--<br/>--%>
<%--<br/>--%>
<%--<br/>--%>

<%--<label>Text:</label>--%>

<%--<label><textarea rows="10" cols="45" name="text" required><c:out value="${updatingBook.text}"/></textarea></label>--%>

<%--<br/>--%>
<%--<br/>--%>
<%--<br/>--%>


<%--<label>--%>
<%--<p>Author:</p>--%>
<%--<select name="author">--%>
<%--<c:forEach items="${authorList}" var="a">--%>
<%--<option--%>
<%--<c:if test="${a.id == updatingBook.author.id}">selected="selected"</c:if>--%>
<%--value="${a.id}">${a.fio}--%>
<%--</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</label>--%>

<%--<input type="submit" name="Send" value="Send">--%>

<%--</form>--%>

<form:form modelAttribute="newBook" method="POST" action="${pageContext.request.contextPath}/books/add"
           enctype="multipart/form-data">

    <<form:hidden path="id" />

    <table>

        <tr>
            <td>Title:</td>
            <td><form:textarea cols="60" rows="8" path="title"/></td>
            <td><form:errors path="title"/></td>

        </tr>

        <%--<tr>--%>
            <%--<td>Image:</td>--%>
            <%--<td><label for="image"><input name="image" type="file"/></label></td>--%>

        <%--</tr>--%>

        <tr>
            <td>Text:</td>
            <td><form:textarea cols="60" rows="8" path="text"/></td>
            <td><form:errors path="text"/></td>

        </tr>

        <tr>
            <td>Authors:</td>
            <td><form:select path="author" items="${authorList}" itemLabel="fio" itemValue="id"/></td>
            <td><form:errors path="author"/></td>
        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="Создать"></td>
            <td></td>
        </tr>


    </table>


</form:form>


</body>
</html>
