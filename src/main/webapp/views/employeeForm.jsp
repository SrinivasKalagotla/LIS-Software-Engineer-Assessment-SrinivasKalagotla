<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Employee Form</title>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
<div class="container">
    <h2>Employee Form</h2>
        <%--@elvariable id="employeeDTO" type="java"--%>
        <form:form modelAttribute="employeeDTO" action="/employees" method="POST">
        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <form:input path="name" />
            <form:errors path="name" cssClass="error-message"/>
        </div>
        <div class="form-group">
            <form:label path="age">Age:</form:label>
            <form:input path="age" />
        </div>
        <div class="form-group">
            <form:label path="title">Title:</form:label>
            <form:input path="title" />
            <form:errors path="title" cssClass="error-message"/>
        </div>
        <div class="form-group">
            <form:label path="hometown">Hometown:</form:label>
            <form:input path="hometown" />
        </div>
            <button type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>
