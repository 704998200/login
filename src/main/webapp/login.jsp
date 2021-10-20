<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script 
	src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js">
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="border: 1px lightgreen solid; margin: 30px; padding: 20px;">
		<h4>Login</h4>
		<form action="login" method="post">
			<p>account
			<input id="account" name="account" type="text" /></p>
			<p>password
			<input id="password" name="password" type="password" /></p>
			<input type="submit" value="登录" />
		</form>
		<button id="reset">重置</button>
	</div>
	<div><% if(request.getAttribute("info")==null){
		out.print("");
	}else {
	out.print(request.getAttribute("info"));
	}
	%></div>
	
</body>
<script type="text/javascript">
	$(document).ready(function(){
      $("#reset").click(function(){
        $("#account").val("");
         $("#password").val("");
      });
    });
</script>
</html>