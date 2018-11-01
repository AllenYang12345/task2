<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 18-9-26
  Time: 下午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>报名信息编辑界面</title>
</head>
<body>
    <div style="width: 500px;margin: 0px auto;text-align: center">
        <div style="text-align: center;margin-top: 40px;">
            <%--<base href="${pageContext.request.contextPath}/">--%>
                <form method="post" action="<c:url value="/user/updateUser"/>">
                <div>姓名：<input name="name" value="${u.name}" type="text"></div>
                <div>QQ号：<input name="qq" value="${u.qq}" type="text"></div>
                <div>修真类型：<input name="train_major" value="${u.train_major}" type="text"></div>
                <div>入学时间：<input name="admiss_time" value="${u.admiss_time}" type="text"></div>
                <div>毕业院校：<input name="graduate_school" value="${u.graduate_school}" type="text"></div>
                <div>学号：<input name="online_number" value="${u.online_number}" type="text"></div>
                <div>日报：<input name="daily_link" value="${u.daily_link}" type="text"></div>
                <div>立愿：<input name="oath" value="${u.oath}" type="text"></div>
                <div>辅导师兄：<input name="coaching_senior" value="${u.coaching_senior}" type="text"></div>
                <div>哪里知道：<input name="where_know" value="${u.where_know}" type="text"></div>
                <%--<div>更新时间：<input name="stutime" value="${u.stutime}" type="text"></div>--%>
                <input type="hidden" value="${u.id}" name="id">
                <%--隐藏id但是一定要写因为需要根据id修改--%>
                <%--name代表属性名，value代表属性值--%>
                <input type="submit" value="修改">
            </form>
        </div>
    </div>
</body>
</html>
