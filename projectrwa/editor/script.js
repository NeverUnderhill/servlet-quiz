getQuizzesQuestions();
document.getElementById('myfile').addEventListener('change', handleFileSelect, false);
function handleFileSelect(evt) {
    var files = evt.target.files;
    var f = files[0];
    var reader = new FileReader();

    reader.onload = (function(theFile) {
        return function(e) {
            document.getElementById('logoimg').innerHTML = `<img src="${e.target.result}" title="${theFile.name}" onclick="$('#myfile').trigger('click'); return false;"/>`;
        };
    })(f);

    reader.readAsDataURL(f);
}
