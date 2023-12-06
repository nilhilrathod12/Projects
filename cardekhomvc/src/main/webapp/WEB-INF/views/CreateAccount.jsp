<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
.btn-color {
	background-color: #0e1c36;
	color: #fff;
}

.profile-image-pic {
	height: 200px;
	width: 200px;
	object-fit: cover;
}

.cardbody-color {
	background-color: #ebf2fa;
}

a {
	text-decoration: none;
}
.container{
height: 200px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center text-dark mt-5">Create Account Form</h2>
				
				<div class="card my-5">

					<form class="card-body cardbody-color p-lg-5" action="./createAccount" method="post">

						<div class="text-center">
							<img
								src="https://hindubabynames.info/wp-content/themes/hbn_download/download/e-commerce-companies/cardekho-logo.png"
								class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
								width="200px" alt="profile">
						</div>
                         <div class="mb-3">
							<input type="text" class="form-control" id="Username"
								aria-describedby="emailHelp" name="name" placeholder="Name">
						</div>
						<div class="mb-3">
							<input type="text" class="form-control" id="Username"
								aria-describedby="emailHelp" name="email" placeholder="Email">
						</div>
						<div class="mb-3">
							<input type="text" class="form-control" id="Username"
								aria-describedby="emailHelp" name="username" placeholder="User Name">
						</div>
						<div class="mb-3">
							<input type="password" class="form-control" name="password" id="password"
								placeholder="password">
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-color px-5 mb-5 w-100">Create Account</button>
						</div>
						<div id="emailHelp" class="form-text text-center mb-5 text-dark">
							Already Have An Account? <a href="./login" class="text-dark fw-bold"> Login
								</a>
						</div>
					</form>
					<%if(msg != null){ %>
					<h3><%=msg %></h3>
					<%} %>
				</div>

			</div>
		</div>
	</div>
</body>
</html>