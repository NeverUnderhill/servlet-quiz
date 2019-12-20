<!DOCTYPE html>  

<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="../style.css" type="text/css" media="screen" title="no title" charset="utf-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="./adminFunctions.js" charset="utf-8"></script>

		<title>View Quizess</title>  
	</head>  
	<body>  
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">Quizzicle</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
							<a class="nav-link" href="index.jsp">Editors<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item active">
							<a class="nav-link" href="quizzes.jsp">Quizzes<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="logout.jsp">Log out</a>
						</li>
						<li class="nav-item">
							<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">
                            <i class="fa fa-edit"></i>
                            <%out.print(" " + session.getAttribute("admin"));
                            %>
                            </a>
						</li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search" placeholder="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>

		</div>
		<div class="container">
			<div class="row justify-content-center">
				<h1 id="title">Quizess List</h1>  
			</div>
			<div class="row" style="text-align:center">
 				<table class="table col-6" id="quizzesTable">  
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Editor</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Number</td>
							<td>Title</td>  
							<td>Editor</td>  
							<td>
								<button type="button" class="btn btn-success"
													  onclick="editQuiz(this.parentNode.parentNode.rowIndex - 1)"><i class="fa fa-pencil"></i></button>
								<button type="button" class="btn btn-danger"
													  onclick="deleteQuiz(this.parentNode.parentNode.rowIndex - 1);location.reload();"><i class="fa fa-trash"></i></button>
							</td>
						</tr>  
					</tbody>
				</table>  
			</div>
			<div class="row justify-content-center">
				<button type="button" class="btn btn-primary mx-1" onclick="window.location.href = 'addquiz.jsp'">Add quiz</button>
			</div>
		</div>
		<br/>
		<script charset="utf-8">
			getQuizzes();
		</script>
	</body>  
</html>  


