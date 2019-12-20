function getEditorQuizzes(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = eval(xhttp.response);
            var table = document.getElementById("editorQuizzesTable");
            for(i = 1; i <= arr.length; i++){
                if(!table.rows.item(i)){
                    table.appendChild(table.rows.item(1).cloneNode(true));
                }
                table.rows.item(i).cells.item(0).innerHTML = i;
                table.rows.item(i).cells.item(1).innerHTML = arr[i - 1].name;
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "getEditorQuizzes", true);
    xhttp.send();
}

function getQuizzesQuestions(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = eval(xhttp.response);
            var table = document.getElementById("quizQuestionsTable");
            if(arr){
                console.log(arr);
                for(i = 1; i <= arr.length; i++){
                    if(!table.rows.item(i)){
                        table.appendChild(table.rows.item(1).cloneNode(true));
                    }
                    table.rows.item(i).cells.item(0).innerHTML = i;
                    table.rows.item(i).cells.item(1).innerHTML = arr[i - 1].text;
                    table.rows.item(i).cells.item(2).innerHTML = arr[i - 1].time;
                }
            }
            else{
                table.rows.item(1).style.visibility = "hidden";
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "getQuizzesQuestions", true);
    xhttp.send();
}

function getResults(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = JSON.parse(xhttp.response);
            var table = document.getElementById("resultsTable");
            if(arr){
                console.log(arr);
                for(i = 2; i <= arr.length; i++){
                    var node = table.rows[1].cloneNode(true); 
                    table.appendChild(node);
                }
                for(i = 1; i <= arr.length; i++){
                    var text = document.createTextNode(i);
                    table.rows[i].children[0].appendChild(text);
                    var text = document.createTextNode(arr[i - 1].name);
                    table.rows[i].children[1].appendChild(text);
                    var text = document.createTextNode(arr[i - 1].email);
                    table.rows[i].children[2].appendChild(text);
                    var text = document.createTextNode(arr[i - 1].quiz);
                    table.rows[i].children[3].appendChild(text);
                    var text = arr[i - 1].points + "/" + arr[i - 1].max_points;
                    table.rows[i].children[4].children[0].innerHTML = text;
                }
            }
            else{
                table.rows.item(1).style.visibility = "hidden";
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "getResults", true);
    xhttp.send();
}

function saveResults(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            const data = JSON.parse(xhttp.response);
            exportString("results.csv", ConvertToCSV(data));
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "getResults", true);
    xhttp.send();
}

function ConvertToCSV(objArray) {
            var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
            var str = '';

            for (var i = 0; i < array.length; i++) {
                var line = '';
                for (var index in array[i]) {
                    if (line != '') line += ','
                    line += array[i][index];
                }
                str += line + '\r\n';
            }
            return str;
        }

function exportString(filename, csvFile) {
    var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
    if (navigator.msSaveBlob) { // IE 10+
        navigator.msSaveBlob(blob, filename);
    } else {
        var link = document.createElement("a");
        if (link.download !== undefined) { // feature detection
            // Browsers that support HTML5 download attribute
            var url = URL.createObjectURL(blob);
            link.setAttribute("href", url);
            link.setAttribute("download", filename);
            link.style.visibility = 'hidden';
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        }
    }
}

function editEditorsQuiz(row){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            window.location.href = '../editor/editquiz.jsp';
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "editEditorsQuiz?row=" + row, true);
    xhttp.send();
}

function deleteEditorsQuiz(row){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var msg = xhttp.responseText;
            if(msg === "correcc"){
                document.getElementById("editorQuizzesTable").deleteRow(row + 1);
            }
            else{
                alert("Could not delete item");
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "deleteEditorsQuiz?row=" + row, true);
    xhttp.send();
}

function selectQuestion(row){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var msg = xhttp.responseText;
            if(msg === "correcc"){
                window.location.href = '../editor/editquestion.jsp';
            }
            console.log(msg);    
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "selectQuestion?row=" + row, true);
    xhttp.send();
}

function deleteQuestion(row){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            window.location.href = '../editor/editquiz.jsp';
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "deleteQuestion?row=" + row, true);
    xhttp.send();
}

function loadAnswers(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = JSON.parse(xhttp.response);
            if(arr){
                document.getElementById("text").value = arr.text;
                document.getElementById("time").value = arr.time;
                for(var i = 1; i < 9; i++){
                    document.getElementById("answer" + i).value = arr.answers[i - 1];
                    document.getElementById("correct" + i).checked = convertChecked(arr.correcc[i - 1]);
                }
            }
            else{
                alert("Empty question");
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "loadAnswers", true);
    xhttp.send();
    function convertChecked(a){
        if(a === "1")
            return true;
        else
            return false;
    }
}

function initQuiz(){
    var xhttp = new XMLHttpRequest();
    var cookieString = getCookie("excludedQuizzes");
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = xhttp.response;

            localStorage.setItem("questions", arr);
            var quizId = JSON.parse(localStorage.questions)[0].quiz_id;
            localStorage.setItem("index", "0");
            localStorage.setItem("points", "0");
            localStorage.setItem("totalQuestions", JSON.parse(localStorage.getItem("questions")).length);
            localStorage.setItem("quiz_id", quizId);

            cookieString === "" ? cookieString = quizId : cookieString += "," + quizId;
            console.log(cookieString);
            setCookie("excludedQuizzes", cookieString, 2);
            window.location.href = "./user/index.jsp";
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("POST", "getRandomQuiz", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("excludedQuizzes=" + encodeURI(cookieString));
}

function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
  var expires = "expires="+d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function checkCookie() {
  var user = getCookie("username");
  if (user != "") {
    alert("Welcome again " + user);
  } else {
    user = prompt("Please enter your name:", "");
    if (user != "" && user != null) {
      setCookie("username", user, 365);
    }
  }
}
