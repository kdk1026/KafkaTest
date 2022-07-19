<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>kafka_send</title>
</head>
<body>

	<h1>Send a Message</h1>
	<form action="onsend" method="post">
		MessageText:<textarea name="message">${time}</textarea>
		<br />
		<input type="submit" value="Submit">
	</form>

	<h2>
		<a href="welcome">RETURN HOME</a>
	</h2>

</body>
</html>