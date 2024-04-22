<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Confirmation Page</title>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
<div class="container">
    <h2>Confirmation of Submission</h2>
    <h3>Submitted Information</h3>
        <div class="submitted-group">
            <p>Name: ${employee.name}</p>
            <p>Age: ${employee.age}</p>
            <p>Title: ${employee.title}</p>
            <p>Hometown: ${employee.hometown}</p>
        </div>

    <h3>Previous Entries</h3>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Title</th>
                <th>Hometown</th>
            </tr>
            <c:forEach items="${allEmployees}" var="employee">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.age}</td>
                <td>${employee.title}</td>
                <td>${employee.hometown}</td>
            </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
