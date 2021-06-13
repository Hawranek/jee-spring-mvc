<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 13.06.2021
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Multiply</title>
</head>
<body>
<h4>Tabliczka mnożenia</h4>
<table border="1">
    <c:forEach begin="1" end="${size}" var="i">
        <tr>
            <c:forEach begin="1" end="${size}" var="j">
                <td>${i*j}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
