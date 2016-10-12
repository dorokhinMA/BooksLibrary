<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<html>
<head>
    <title>Books Library</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%@ include file="header.jsp" %>


<table width="100%">

    <tr>

        <td width="20%" style="background-color: darkgrey">

            <c:forEach items="${authors}" var="a">

                <table>

                    <tr>
                        <td>
                            <h3>${a.fio}</h3>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/authors/${a.id}">Список книг</a>
                        </td>
                    </tr>

                </table>

                <hr/>

            </c:forEach>

        </td>


        <td width="60%" align="left">
            <c:forEach items="${books}" var="book">

                <table>
                    <tr>
                        <td>
                            <h2>${book.title}</h2>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <h3>${book.author.fio}</h3>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/get/${book.id}/${book.author.id}">Open</a>
                            <br/>
                            <a href="${pageContext.request.contextPath}/books/update/${book.id}/${book.author.id}">Update</a>
                            <br/>
                            <a href="${pageContext.request.contextPath}/books/delete/${book.id}">Delete</a>
                        </td>
                    </tr>

                </table>

                <hr/>

            </c:forEach>
        </td>


        <td width="20%" style="background-color: darkgrey" align="left">

            <form action="${pageContext.request.contextPath}/books/find" method="post">

                <table>
                    <tr>
                        <td><label id="t"><p>Найти книгу:</p></label></td>
                        <td><input type="text" name="title" required title="t"/></td>
                    </tr>

                    <tr>
                        <td>
                            <input type="submit" value="Найти"/>
                        </td>
                    </tr>
                </table>

            </form>

            <br/>
            <hr/>

            <a href="${pageContext.request.contextPath}/books/add">Добавить новую книгу</a>

            <br/>
            <hr/>

            <form:form method="post" action="${pageContext.request.contextPath}/books/authors/add" modelAttribute="newAuthor" >

                <table>
                    <tr>
                        <td><form:label path="fio">Добавить нового автора:</form:label></td>
                        <td><form:input path="fio"/></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Добавить"/></td>
                    </tr>
                </table>

            </form:form>

            <br/>
            <hr/>

        </td>


    </tr>

</table>


</body>
</html>
