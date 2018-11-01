<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 18-8-12
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>登录界面</title>
</head>
<h2>登录界面</h2>
   <body>
   <c:if test="${!empty error}">
       <font color="red"><c:out value="${error}"/> </font>
   </c:if>
       <form action="<c:url value="login"/>" method="post">
           用户名：<input type="text" name="userName" /><br/>
           密&nbsp;&nbsp;码：<input type="password" name="password"/><br/>
           <input type="submit" value="登录"><br/>
           <a href="login">注册</a>
       </form>
   </body>
</html>
