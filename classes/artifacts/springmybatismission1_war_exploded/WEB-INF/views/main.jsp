<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>liststudent</title>
</head>
<body>
    <h2>欢迎登录！</h2>
    <div style="width: 500px;margin: 0px auto;text-align: center">
<%--<div>是html的层级标签；
    style代表该层风格；
    width指宽度，px设置以像素计的宽度，%设置以包含元素的百分比计的宽度
    <TABLE width="150%">的意思就是：设置table的宽度为包含table标签(比如：div）宽度的150%
    margin指上边距 auto指左边距自动；
    text-align指文本对齐方式-center指居中对齐--%>
        <table align='center' border='1' cellspacing='0' width='150%'>
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
                <td>QQ号</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>学号</td>
                <td>立愿</td>
                <td>辅导师兄</td>
                <td>日报</td>
                <%--<td>更新时间</td>--%>
                <td>编辑</td>
                <td>删除</td>
            </tr>
            <u:forEach items="${cs}" var="s" varStatus="st">
                <%--<u>为文本添加下划线--%>
                <%--<c:forEach>(***)
                循环遍历数据（数组，集合，Map集合）
                属性
                var:遍历数据的类型
                items：要遍历的内容
                varStatus：记录循环遍历的信息--%>
                <%--${}叫做EL表达式，一种简化的jsp表达式--%>
                <td>${s.id}</td>
                <td>${s.stuname}</td>
                <td>${s.stuqq}</td>
                <td>${s.stutype}</td>
                <td>${s.stucreate}</td>
                <td>${s.stuschool}</td>
                <td>${s.stuid}</td>
                <td>${s.stupromise}</td>
                <td>${s.stusenior}</td>
                <td>${s.studaily}</td>
                <%--<td>${s.stutime}</td>--%>
                <td><a href="update?id=$ ">编辑</a></td>
                <td><a href="deleteStudent?id=${s.id}">删除</a></td>
                </tr>
            </u:forEach>
        </table>
    </div>
</body>
</html>