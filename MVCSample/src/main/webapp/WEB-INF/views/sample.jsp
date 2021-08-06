<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- directive -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="hr/count.jsp" %> <!-- include directive -->
<jsp:include page="hr/count.jsp"/> <!-- include standard action tag -->
<c:import url="hr/count.jsp"/>	   <!-- import core library -->
</head>
<body>
<%!
// declaration
String[] strList = {"Hello", "World", "Kosa"};
%>
<c:set var="strList" value='"Hello", "World", "Kosa"' scope="request"></c:set>

<c:forEach var="msg" items="${strList}">
<h1>${msg}</h1>
</c:forEach>
<%
//scriptlet, 자바 코드 작성
System.out.println("콘솔에 텍스트 출력");
out.println("<h1>브라우저 화면에 텍스트 출력</h1>");
for (String msg : strList) {
	out.println("<h2>" + msg + "</h2>");
}
%>
<h1>브라우저 화면에 텍스트 출력2</h1>
</body>
</html>