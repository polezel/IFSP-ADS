<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="java.util.Date" %>

<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Hello World!</title>
	</head>
	<body>
		<% SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
		<h1>Hello World!</h1>
		<p>Bem-vindo à página.</p>
		<p>A data e hora atual no servidor é <%= df.format(new Date()) %>.</p>
	</body>
</html>