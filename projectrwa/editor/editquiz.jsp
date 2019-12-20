<!DOCTYPE html>  

<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="./style.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="../functions.js" charset="utf-8" defer></script>
        <script src="./script.js" charset="utf-8" defer></script>
        <script src="editorFunctions.js" charset="utf-8" defer></script>

        <title>Edit Quiz Questions</title>  
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
                                <%out.print(" " + session.getAttribute("id"));%>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>   
        <div class="container">
            <div class="row justify-content-center" id="logoimg">
                <img src="<%out.print("../img/" + session.getAttribute("quiz_id"));%>" alt="..."/ onclick="$('#myfile').trigger('click'); return false;">
            </div>
            <div class="row justify-content-center">
                    <form method="post" action="multiPartServlet" enctype="multipart/form-data">
                        <input type="file" class="custom-file-input" name="multiPartServlet" id="myfile" accept="image/*" style="display:none">
                        <input type="submit" class="btn btn-secondary btn-sm" id="uploadbtn" value="Upload photo"/>
                    </form>
            </div>
            <div class="row justify-content-center">
                <h1 id="title" class="my-auto" ><%out.print(session.getAttribute("quiz_name"));%></h1>  
            </div>
            <div class="row justify-content-center">
                <table class="table col-6" id="quizQuestionsTable">  
                    <thead>
                        <tr>
                            <td>#</td>
                            <td>Question</td>
                            <td>Time</td> 
                            <td>Actions</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr draggable="true" ondragover="event.preventDefault()" ondragstart="drag(event)" ondrop="drop(event);">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td style="white-space: nowrap">
                                <button type="button" class="btn btn-success " onclick="selectQuestion(this.parentNode.parentNode.rowIndex - 1)"><i class="fa fa-pencil"></i></a>
                                <button type="button" class="btn btn-danger mx-1" onclick="deleteQuestion(this.parentNode.parentNode.rowIndex - 1)"><i class="fa fa-trash"></i></a>
                            </td>
                        </tr>
                    </tbody>
                </table>  
            </div>
            <div class="row justify-content-center">
                <button type="button" class="btn btn-success" id="right-panel-link" onclick="window.location.href = './addquestion.jsp';">Add Question</button>
            </div>
            <div class="row justify-content-center mt-3">
            </div>
        </div>
    </body>  
</html>  
