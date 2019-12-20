<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
        <script src="../functions.js" charset="utf-8"></script>
        <link rel="stylesheet" href="../style.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <script src="userFunctions.js" charset="utf-8"></script>
        <script src="progressbar.js" charset="utf-8"></script>
        <script src="progressbar.min.js" charset="utf-8"></script>
        <link href="https://fonts.googleapis.com/css?family=Raleway:400,300,600,800,900" rel="stylesheet" type="text/css">
        <title>Quiz</title>
        <style type="text/css" media="screen">
span {
    display: block;
}
        </style>
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
                </div>
            </nav>
        </div>
        <div style="text-align:center">
            <h2 id="title">CONGRATULATIONS</h2>
            <h3 style='font-family:Raleway, Helvetica, sans-serif;' id="scoreParagraph"></h3>
            <div>
                <div id="container" style="width:15%;height:15%;display:inline-block">
                </div>
            </div>
            <button type="button" class="btn btn-primary mt-2" data-toggle="modal" data-target="#exampleModal">Save your score</button>
        </div>

        <div class="modal fade in" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Save your score</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="" method="post">
                            <div class="form-group mx-auto" style="width:80%">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                            </div>
                            <div class="form-group mx-auto" style="width:80%">
                                <label for="name">First Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Jane" required>
                            </div>
                            <div class="form-group mx-auto" style="width:80%">
                                <label for="surname">Second Name</label>
                                <input type="text" class="form-control" id="surname" name="surname" placeholder="Doe" required>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" onclick="saveScore()" data-dismiss="modal">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script charset="utf-8">
            var p = document.getElementById("scoreParagraph");
            p.innerHTML = "You got " + localStorage.score + " out of " + localStorage.totalScore + " points";

            var bar = new ProgressBar.Circle(container, {
                color: '#aaa',
                strokeWidth: 4,
                trailWidth: 1,
                easing: 'bounce',
                duration: 1400,
                text: {
                autoStyleContainer: false
                },
                from: { color: '#aaa', width: 1 },
                to: { color: '#333', width: 4 },
                step: function(state, circle) {
                circle.path.setAttribute('stroke', state.color);
                circle.path.setAttribute('stroke-width', state.width);
                }
            });
            bar.animate(localStorage.score/localStorage.totalScore);  // Number from 0.0 to 1.0
        </script>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/js/bootstrap.min.js" integrity="sha384-3qaqj0lc6sV/qpzrc1N5DC6i1VRn/HyX4qdPaiEFbn54VjQBEU341pvjz7Dv3n6P" crossorigin="anonymous"></script>

    </body>
</html>
