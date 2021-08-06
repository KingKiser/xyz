<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form action="./new" method="post" enctype="multipart/form-data">
	디렉토리: <input type="text" name="dir" value="/"><br>
	<input type="file" name="file"><br>
	<input type="submit" value= " 업로드 ">
	<input type="reset" value=" 취소"> 
</form>
</body>
</html>