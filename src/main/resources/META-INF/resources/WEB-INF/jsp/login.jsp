<html>
	<head>
		<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login Page</title>
	</head>
	<body>
		<div class="container">
			<h2>Login</h2>
			<form method="post">
				<div  class="mb-3">
					<label for="name" class="form-label">Name</label>
					<input id="name" type="text" name="name" class="form-control" />
				</div>
				<div  class="mb-3">
					<label for="password" class="form-label">Password</label>
					<input id="password" type="password" name="password" class="form-control" />
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
				<p style="color: red;">${error}</p>
			</form>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>