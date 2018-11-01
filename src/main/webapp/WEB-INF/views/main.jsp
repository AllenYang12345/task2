<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生报名记录列表</title>
</head>
<body>

    <div style="width: 500px;margin: 0px auto;text-align: center">
<%--<div>是html的层级标签；
    style代表该层风格；
    width指宽度，px设置以像素计的宽度，%设置以包含元素的百分比计的宽度
    <TABLE width="150%">的意思就是：设置table的宽度为包含table标签(比如：div）宽度的150%
    margin指上边距 auto指左边距自动；
    text-align指文本对齐方式-center指居中对齐--%>
        <table border='1' width='100%'>
            <%--table表格；align属性规定表格相对于周围元素的对齐方式；
            border设置或获取绘制队形周围边框的宽度
            borderColor设置或获取对象的边框色
            borderColorDark设置或获取用于绘制对象3D边框的两种颜色的一种
            cellpadding代表的是边框与其内容的间隙大小；
            cellspacing是边框与边框之间的间隙大小
            --%>
            <%--<tr>代表表格中的一行</tr>
            <td>代表表格中的一列</td>--%>
                <%--‘tr’与‘td’交成一个单元格，在这里就是一行，12列--%>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>学号</td>
                <td>日报</td>
                <td>立誓</td>
                <td>辅导师兄</td>
                <td>哪里知道</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${user_list}" var="item">
                <tr>
                <%--<u>为文本添加下划线--%>
                <%--<c:forEach>(***)
                循环遍历数据（数组，集合，Map集合）
                属性
                var:遍历数据的类型
                items：要遍历的内容
                varStatus：记录循环遍历的信息--%>
                <%--${}叫做EL表达式，一种简化的jsp表达式--%>
                <td>${item.id}<input type="hidden" name="id" value="${item.id}"></td>
                <td>${item.name}</td>
                <td>${item.qq}</td>
                <td>${item.train_major}</td>
                <td>${item.admiss_time}</td>
                <td>${item.graduate_school}</td>
                <td>${item.online_number}</td>
                <td>${item.daily_link}</td>
                <td>${item.oath}</td>
                <td>${item.coaching_senior}</td>
                <td>${item.where_know}</td>
                <td>
                <a href="update?id=${item.id}">编辑</a>
                <a href="deleteUser?id=${item.id}">删除</a>
                </td>
                </tr>
            </c:forEach>
        </table>
    <div align="center">
        <font size="2">第${page.pageNow}页</font>
        <a href="main.action?pageNow=1" rel="external nofollow" rel="external nofollow" >首页</a>
        <c:choose>
            <c:when test="${page.pageNow - 1 > 0}">
                <a href="main.action?pageNow=${page.pageNow - 1}" rel="external nofollow" >上一页</a>
            </c:when>
            <c:when test="${page.pageNow - 1 <= 0}">
                <a href="main.action?pageNow=1" rel="external nofollow" rel="external nofollow" >上一页</a>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${page.totalPageCount==0}">
                <a href="main.action?pageNow=${page.pageNow}" rel="external nofollow" rel="external nofollow" >下一页</a>
            </c:when>
            <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                <a href="main.action?pageNow=${page.pageNow + 1}" rel="external nofollow" >下一页</a>
            </c:when>
            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                <a href="main.action?pageNow=${page.totalPageCount}" rel="external nofollow" rel="external nofollow" >下一页</a>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${page.totalPageCount==0}">
                <a href="main.action?pageNow=${page.pageNow}" rel="external nofollow" rel="external nofollow" >尾页</a>
            </c:when>
            <c:otherwise>
                <a href="main.action?pageNow=${page.totalPageCount}" rel="external nofollow" rel="external nofollow" >尾页</a>
            </c:otherwise>
        </c:choose>
    </div>
    <div>
    <json:object>
        <json:property name="code" value="${code}"/>
        <json:property name="message">
            <spring:message code="${code}"/>
        </json:property>
    </json:object>
    </div>
</body>
</html>