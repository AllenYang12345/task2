<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Message Tag Demo</title>
</head>
<body>
<h1><spring:message code="welcome" arguments="Justin,Lin"/></h1>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}" arguments="1"/>
    </json:property>
</json:object>
</body>
</html>