let srcIndex;

function drop(ev){
    dstIndex = ev.currentTarget.rowIndex - 1;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var arr = xhttp.responseText;
            if(arr === "correcc"){
                window.location.href = 'editquiz.jsp';
            }
        }
    }
    if (!xhttp) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }
    xhttp.open("GET", "swapQuestions?src=" + srcIndex + "&dst=" + dstIndex, true);

    xhttp.send();
}

function drag(ev){
    srcIndex = ev.srcElement.rowIndex - 1;
}
