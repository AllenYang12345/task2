<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 18-8-29
  Time: 下午11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
</head>
<body>
        <h3>注册界面</h3><br/>
        <c:if test="${!empty error}">
            <font color="red"><c:out value="${error}"/> </font>
        </c:if>
        <form action="addonelogin" method="post">
            <table>
                <tr>
                    <td><label>登录名：</label></td>
                    <td><input type="text" id="userName" name="userName"></td>
                </tr>
                <tr>
                    <td><label>密码：</label></td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <td><input id="submit" type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
</body>
</html>
