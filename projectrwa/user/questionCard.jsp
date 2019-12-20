<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../style.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
        <script src="../functions.js" charset="utf-8"></script>
        <script src="userFunctions.js" charset="utf-8"></script>
        <title>Quiz</title>
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
                            <a class="nav-link" href="../index.html">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">
                                <i class="fa fa-edit"></i>
                                <%out.print(" " + session.getAttribute("currentQuizName"));
                                   %>
                            </a>
                        </li>
                    </ul>
                    <a id="playercount" class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"></a>
                </div>
            </nav>
        </div>

        <div style="text-align:center">
            <br></br>
            <div hidden class="row justify-content-sm-center" id="card">
                <div class="card border-info">
                    <div class="card-header" id="header">Question 1</div>
                    <div class="card-body text-info" id="questionCard"></div>
                    <div class="progress">
                        <div class="progress-bar" role="progressbar" style="width:100%" aria-valuemin="0" aria-valuemax="100" id="bar"></div>
                    </div>
                </div>
                <div class="btn-group-vertical">
                    <button type="button" class="btn btn-info" onclick="answerQuestion();">Next</button>
                    <button type="button" class="btn btn-secondary" onclick="skipQuestion();">Skip</button>
                </div>
            </div>
        </div>
        <script charset="utf-8">
            initQuestion();

            let ws = new WebSocket("ws://localhost:8080/quiz/projectrwa/user/webSocket");

            ws.onopen = function(event){
                ws.send("a");
            }

            ws.onmessage = function(event){
                document.getElementById("playercount").innerHTML = "Quizzes being played " + event.data;
            }
        </script>

    </body>
</html>
