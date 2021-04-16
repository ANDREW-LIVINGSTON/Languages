<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Languages</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <h1>All Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Current Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allLanguages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td><form action="/languages/${language.id}" method="POST">
            	<input type="hidden" name="_method" value="delete">
            	<input type="submit" value="destroy">
            </form>
            <a href="/languages/${language.id}/edit">edit</a>
            </td>
        
        </tr>
        </c:forEach>
    </tbody>
</table>
<br>
<br>
<form:form action="/languages" method="post" modelAttribute="newLanguage">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Current Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>
