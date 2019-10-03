<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<title>Login</title>
<body style="background-color:#DEEDF1">
	<h2 style="color:red">Sorry..! User Name OR Password not correct..!<br/>
		Please try again.
	</h2>
	<form action="Login" method="POST">
		<table style="background-color:skyblue; width: 100%">
			<tr>
				<th align="left">*UserName <br>
					<input type="text" name="username" placeholder="UserName"/>
				</th>
				<th align="left">*Password <br>
					<input type="password" name="pw" placeholder="Password"/>
				</th>
				<th>
					<td colspan="2" align="left">
						<input type="submit" value="Login"class="btn"/>
					</td>
				</th>
			</tr>
		</table>
		<h1 align="right"><a href="login.jsp">Sign Up</a></h1>
	</form>
</body>