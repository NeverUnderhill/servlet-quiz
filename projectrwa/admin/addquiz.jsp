<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../style.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <script src="../functions.js" charset="utf-8"></script>
        <title>Add quiz</title>
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
                            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout.jsp">Log out</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">
                                <i class="fa fa-edit"></i>
                                <%out.print(" " + session.getAttribute("id"));
                                   %>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>

        </div>
        <div class="container" style="text-align:center">
            <div class="container">
                <div class="row justify-content-center">
                    <h1 id="title">ADD QUIZ</h1>
                </div>
                <div class="row justify-content-center">
                    <form action="addQuiz" method="POST" >
                        <div class="form-inline">
                            <input type="text" class="form-control mr-sm-2" id="quizname" name="name" placeholder="Quiz name" required>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
