<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<body style="background-color:#DEEDF1">

<form action="Login" method="POST">
	<table style="background-color:skyblue; width: 100%">
		<tr>
			<th align="left">UserName<br>
				<input type="text" name="username" placeholder="UserName"/>
			</th>
			
			<th align="left">Password<br>
				<input type="password" name="pw" placeholder="Password"/>
			</th>
			<td colspan="2" align="left">
					<input type="submit" value="Login"class="btn"/>
<!-- 					<input type="reset" value="Clear"class="btn"/></br> -->
			</td>
		</tr>
	</table>
</form>
<center><h1 style="color:purple">New User Registration</h1></center>
	<form action="Registration" method="post">
		<table align="center" style="background-color:gold">
		<tr>
				<td>*UserName:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>*Password:</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Security Type:</td>
				<td><select name="sques">
					<option value="">Please Select One</option>
					<option value="What is your pet Name">Your Pet Name</option>
					<option value="What is your last Name">Your Last Name</option>
					<option value="What is your first school">Your First School</option>
				</select></td>
			</tr>
			<tr>
				<td>Answer:</td>
				<td><input type="text" name="ans"></td>
			</tr>
			<tr>
				<td>Mobile No.:</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Sign Up">
				<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>