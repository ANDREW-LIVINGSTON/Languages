<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Language</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<h1><c:out value="${language.name}"/></h1>
<p>Creator: <c:out value="${language.creator}"/></p>
<p>Current Version: <c:out value="${language.currentVersion}"/></p>
<a href="/books/${book.id}/edit">Edit Book</a>
<form action="/languages/${language.id}/edit" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

	
</body>
</html>