<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<H1>Login</H1>
		<form method="post">
			<label>Name: <input type="text" name="name" /></label><br/>
			<label>Password: <input type="password" name="password" /></label><br/>
			<button>Login</button>
			<p style="color: red;">${error}</p>
		</form>
	</body>
</html>