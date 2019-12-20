<!DOCTYPE html>  

<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="../style.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="../functions.js" charset="utf-8"></script>

        <title>View Quizess</title>  
    </head>  
    <body>  
        <style type="text/css" media="screen">
            img {
                display: block;
                max-width:200px;
                max-height:200px;
                width: auto;
                height: auto;
            }
        </style>
        <div class="container">
            <br></br>
            <br></br>
            <div class="row justify-content-center">
                <img src=<%
                     out.print("\"../img/" + session.getAttribute("quiz_id") + "\"");
                     %> class="rounded float-right" alt="quiz_logo.jpg">
            </div>
            <div class="row justify-content-center">
                <p class="h1">Welcome to
                <%String name = (String) session.getAttribute("currentQuizName");
                   out.println(name);
                   %> quiz</p>
            </div> 
            <div class="row justify-content-center">
                <button type="button" class="btn btn-info" onclick="window.location.href = 'questionCard.jsp'">Start</button>
            </div> 
        </div>
        <script charset="utf-8">
            $('body').css('display', 'none');
                $('body').fadeIn(1500);
                localStorage.setItem("score", "0");
                localStorage.setItem("totalScore", "0");
        </script>
    </body>  
</html>  


