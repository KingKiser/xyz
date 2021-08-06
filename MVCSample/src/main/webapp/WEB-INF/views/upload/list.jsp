<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>아이디</th>
	<th>디렉토리</th>
	<th>파일명</th>
	<th>크기</th>
	<th>형식</th>
	<th>날짜</th>
	<th>삭제</th>
</tr>
<c:forEach var="file" items="${fileList}">
<tr>
	<td>${file.fileId}</td>
	<td>${file.directoryName}</td>
	<td><a href="../pds/${file.fileId}">${file.fileName}</a></td>
	<td>${file.fileName}</td>
	<td>${file.fileSize}</td>
	<td>${file.fileContentType}</td>
	<td>${file.fileUploadDate}</td>
	<td><a href="./delete/${file.fileId}">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>