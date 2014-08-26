<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div align="center" >
<form action="/crud/page1" name="page1" id="form" style="border:2px sloid black" method="post" >
	<div style="background-color:white;border:2px solid black;width:250px;height:120px;" align="left">
		<b>password:</b><input type="password"  value="enter password" name="password" path="password"></input>
		<br></br>
		<b>email-id:&nbsp;&nbsp;</b><input type="text" value="enter e-mail" name="emailid" path="email" ></input>
		<br></br>
		
		<input type="submit" value="SUBMIT" class="btn" />
	</div>
	</form>
	</div>
</body>
</html>
