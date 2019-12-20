function initQuestion(){
    loadQuestion();
    $('body').css('display', 'none');
    $('body').fadeIn(1500);
    initTimer();
    timer1 = window.setInterval(cdown, 100);
}

function loadQuestion(){
    var arr = JSON.parse(localStorage.getItem("questions"));
    var index = JSON.parse(localStorage.getItem("index"));
    var card = document.getElementById("questionCard"); 
    card.innerHTML = "";

    document.getElementById("header").innerHTML = "Question " + (index + 1);
    var questionText = document.createElement("h5");
    questionText.classList.add("card-title");
    questionText.innerHTML = arr[index].text;
    card.appendChild(questionText);
    for(var i = 1; i < 9; i++){
        if(arr[index].answers[i-1]){
            var html = 
                `<span class="input-group-text" id="">Placeholder answer 1</span>
                    <div class="input-group-append" style="float:right">
                    <div class="input-group-text"><input type="checkbox"></div>`
            var prototypeChild = document.createElement("div");
            prototypeChild.classList.add("input-group");
            prototypeChild.classList.add("input-group-lg");
            prototypeChild.classList.add("mb-1");
            prototypeChild.innerHTML = html; 
            prototypeChild.children[0].innerHTML = arr[index].answers[i - 1];
            prototypeChild.id = "answer" + i;
            prototypeChild.children[1].children[0].children[0].checked = false;
            prototypeChild.children[1].children[0].children[0].id = "correcc" + i;
            card.appendChild(prototypeChild);
        }
    }
    document.getElementById("card").hidden = false;
}

function answerQuestion(){
    window.clearInterval(timer1);
    gradeAnswer();
    updateMaxScore();
    removeQuestion();
    nextQuestion();
}

function gradeAnswer(){
    var arr = JSON.parse(localStorage.getItem("questions"));
    var index = JSON.parse(localStorage.getItem("index"));
    var card = document.getElementById("questionCard"); 
    var score = 0;
    var correct = true;

    var j = 1;
    for(var i = 0; i < 8; i++){
        if(arr[index].answers[i]){
            if(card.children[j].children[1].children[0].children[0].checked != convertChecked(arr[index].correcc[i])){
                correct = false;
                break;
            }
            if(convertChecked(arr[index].correcc[i])){
                score++;
            }
            j++;
        }
    }
    if(correct){
        localStorage.setItem("score", parseInt(localStorage.getItem("score")) + score);
    }
}

function updateMaxScore(){
    var arr = JSON.parse(localStorage.getItem("questions"));
    var index = JSON.parse(localStorage.getItem("index"));
    var totalScore = 0;

    for(var i = 0; i < 8; i++){
        if(arr[index].answers[i] && convertChecked(arr[index].correcc[i])){
            totalScore++;
        }
    }
    localStorage.setItem("totalScore", parseInt(localStorage.getItem("totalScore")) + totalScore);
}

function removeQuestion(){
    var arr = JSON.parse(localStorage.getItem("questions"));
    var index = JSON.parse(localStorage.getItem("index"));
    var totalQuestions = JSON.parse(localStorage.getItem("totalQuestions"));

    arr.splice(index, 1);
    localStorage.setItem("questions", JSON.stringify(arr));
    localStorage.setItem("totalQuestions", totalQuestions - 1);
}

function nextQuestion(){
    if(JSON.parse(localStorage.getItem("index")) === JSON.parse(localStorage.getItem("totalQuestions"))){
        if(localStorage.getItem("questions") === "[]"){
            window.location.href = "finalScore.jsp";
        }
        else{
            localStorage.setItem("index", "0");
            initQuestion();
        }
    }
    else{
        initQuestion();
    }
} 

function skipQuestion(){
    window.clearInterval(timer1);
    updateTime();
    nextQuestion();
}

function updateTime(){
    var arr = JSON.parse(localStorage.getItem("questions"));
    var index = JSON.parse(localStorage.getItem("index"));
    var bar = document.getElementById("bar");
    var now = parseFloat(bar.getAttribute("aria-valuenow"));
    arr[index].remainingTime = now;
    localStorage.setItem("questions", JSON.stringify(arr));
    localStorage.setItem("index", index + 1)
}

function initTimer(){
    var index = parseInt(localStorage.getItem("index"));
    var arr = JSON.parse(localStorage.getItem("questions"));
    var bar = document.getElementById("bar");
    bar.setAttribute("aria-valuemax", arr[index].time);
    if(arr[index].remainingTime){
        bar.setAttribute("aria-valuenow", arr[index].remainingTime);
    }
    else{
        bar.setAttribute("aria-valuenow", arr[index].time);
    }
    bar.style.width = arr[index].time;
}

function cdown(){
    var bar = document.getElementById("bar");
    var max = parseFloat(bar.getAttribute("aria-valuemax"));
    var now = parseFloat(bar.getAttribute("aria-valuenow"));
    if(now <= 0){
        window.clearInterval(timer1);
        bar.style.width = "0%";
        updateMaxScore();
        removeQuestion();
        nextQuestion();
    }
    else{
        bar.setAttribute("aria-valuenow", now - 0.1);
        bar.style.width = ((now - 0.1) * 100 / max) + "%";
    }
}

function convertChecked(a){
    if(a === "1")
        return true;
    else
        return false;
}

function saveScore(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var msg = xhttp.responseText;
            if(msg === "correcc"){
                alert("updated");
                window.location.href = '../index.html';
            }
            else{
                alert("User with this email alreay played this quiz");
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }

    email = encodeURIComponent(document.getElementById("email").value);
    quiz_id = encodeURIComponent(localStorage.quiz_id);
    name = encodeURIComponent(document.getElementById("name").value);
    surname = encodeURIComponent(document.getElementById("surname").value);
    points = encodeURIComponent(localStorage.score);
    max_points = encodeURIComponent(localStorage.totalScore);
    xhttp.open("GET", "saveScore?email="+email+"&quiz_id="+quiz_id+"&name="+name+"&surname="+surname+"&points="+points+"&max_points="+max_points, true);
    xhttp.send();
}

