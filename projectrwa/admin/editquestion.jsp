<!DOCTYPE html>
<html>
    <head>
        <%@page pageEncoding="UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../style.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="../functions.js" charset="utf-8"></script>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
                            <%out.print(session.getAttribute("id") + " > " + session.getAttribute("quiz_name"));
                                                                            %>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
            <div class="row justify-content-center">
                <h1 id="title">EDIT QUESTION</h1> 
            </div>
            <div class="row justify-content-center">
                <form action="editQuestion" method="POST" >
                    <div class="form-horizontal">
                        <div class="form-group">
                            <textarea class="form-control" rows="3" id="text" name="text" placeholder="Question" required></textarea>
                        </div>
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer1" name="answer1" placeholder="Answer 1">
                        <input type="checkbox" class="form-check-input" id="correct1" name="correct1">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer2" name="answer2" placeholder="Answer 2">
                        <input type="checkbox" class="form-check-input" id="correct2" name="correct2">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer3" name="answer3" placeholder="Answer 3">
                        <input type="checkbox" class="form-check-input" id="correct3" name="correct3">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer4" name="answer4" placeholder="Answer 4">
                        <input type="checkbox" class="form-check-input" id="correct4" name="correct4">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer5" name="answer5" placeholder="Answer 5">
                        <input type="checkbox" class="form-check-input" id="correct5" name="correct5">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer6" name="answer6" placeholder="Answer 6">
                        <input type="checkbox" class="form-check-input" id="correct6" name="correct6">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer7" name="answer7" placeholder="Answer 7">
                        <input type="checkbox" class="form-check-input" id="correct7" name="correct7">
                    </div>
                    <div class="form-inline">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="answer8" name="answer8" placeholder="Answer 8">
                        <input type="checkbox" class="form-check-input" id="correct8" name="correct8">
                    </div>
                    <div class="form-inline">
                        <input type="number" class="form-control mb-2 mr-sm-2" id="time" name="time" required min="1" max="60">
                        <!--<input type="checkbox" style="visibility:hidden">-->
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
        <script charset="utf-8">
                loadAnswers();
        </script>
    </body>
</html>
