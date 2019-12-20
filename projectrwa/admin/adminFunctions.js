function getEditors(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = eval(xhttp.response);
            var table = document.getElementById("editorsTable");
            for(i = 1; i <= arr.length; i++){
                if(!table.rows.item(i)){
                    table.appendChild(table.rows.item(1).cloneNode(true));
                }
                table.rows.item(i).cells.item(0).innerHTML = i;
                table.rows.item(i).cells.item(1).innerHTML = arr[i - 1].id;
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "getEditors", true);
    xhttp.send();
}

function getQuizzes(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = eval(xhttp.response);
            var table = document.getElementById("quizzesTable");
            for(i = 1; i <= arr.length; i++){
                if(!table.rows.item(i)){
                    table.appendChild(table.rows.item(1).cloneNode(true));
                }
                table.rows.item(i).cells.item(0).innerHTML = i;
                table.rows.item(i).cells.item(1).innerHTML = arr[i - 1].name;
                table.rows.item(i).cells.item(2).innerHTML = arr[i - 1].editor;
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "getQuizzes", true);
    xhttp.send();
}

function deleteEditor(editorID){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var msg = xhttp.responseText;
            if(msg === "correcc"){
                document.getElementById("editorQuizzesTable").deleteRow(editorID + 1);
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
    xhttp.open("GET", "deleteEditor?editorID=" + editorID, true);
    xhttp.send();
}
