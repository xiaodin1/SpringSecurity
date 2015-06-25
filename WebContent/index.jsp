<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@include file="/commons/common.jsp" %>
		<title>登录页</title>
		<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${ctx}/static/css/login.css"/>
	</head>
	<body>
		<div class='container' align="center">
			<div class='content'>
				<div class='login-title'>
					<h1>XXX管理系统</h1>
				</div>
			</div>
		</div>
		<div class="container">
	      <form class="form-signin" action="${ctx}/security-login" method="post">
	        <h2 class="form-signin-heading">please sign in</h2>
	        <label for="inputUsername" class="sr-only">Email address</label>
	        <input type="username" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" id="_spring_security_remember_me" name="_spring_security_remember_me" value="true"> Remember me
	          </label>
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	      </form>
    	</div>
    	<div class="container" align="center" style="color:red;">
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.class.name == 'org.springframework.security.authentication.AuthenticationCredentialsNotFoundException'}">
				用户不存在!
			</c:if>
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.class.name == 'org.springframework.security.authentication.BadCredentialsException'}">
				用户名或密码不匹配!
			</c:if>
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.class.name == 'org.springframework.security.authentication.DisabledException'}">
				用户不可用!
			</c:if>
		</div>
	</body>
</html>