<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Assalamu Alaikum Wr. Wb.<c:out value='${sessionScope["name"]}'/></h2>
	<spring:form action="${pageContext.request.contextPath}/welcome.bnu"  >
		<input value="${name}" name="name" /><br/>
		<input type="submit" value="submit">
	</spring:form>
	<spring:form action="${pageContext.request.contextPath}/manageUsers.bnu"  >
		
		<input type="submit" value="manageUsers" >
	</spring:form>
		
</body>
</html>