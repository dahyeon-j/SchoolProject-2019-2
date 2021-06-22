
function maketable() {
    var myt = document.getElementById("myTable");
    var row_ = document.getElementById("makerow").value;
    var col_ = document.getElementById("makecol").value;
    var pattern = /^[0-9]+$/;

    var isOK = 1;
    if(!row_.match(pattern)) {
        alert("열의 값을 숫자로 입력하세요");
        isOK= 0;
    }
    if(!col_.match(pattern)) {
        alert("행의 값을 숫자로 입력하세요");
        isOK= 0;
    }

    if(isOK === 1) {
        for(var i = 0; i < parseInt(row_);i++) {
            var mr =document.createElement('tr');
            for(var j = 0; j < parseInt(col_);j++) {
                mr.appendChild(document.createElement('td'));
            }
            myt.appendChild(mr);
        }
    }
}

function appendTable() {
    var myt = document.getElementById("myTable");
    var ar = document.getElementById("appendrow").checked;
    var ac = document.getElementById("appendcol").checked;
    var ap = document.getElementById("appendPosition").value;
    var pattern = /^[0-9]+$/;
    if(ar===false && ac === false && !ap.match(pattern)) {
        alert("추가할 위치의 행 또는 열의 번호를 숫자로 입력하시고 Radio 버튼을 하나 선택해 주세요")
    }
    else if(ar===false && ac === false) {
        alert("Radio 버튼을 하나 선택해 주세요");
    }
    else if(!ap.match(pattern)) {
        alert("추가할 위치의 행 또는 열의 번호를 숫자로 입력하세요.");
    }
    else
    {
        var position = parseInt(ap);
        var numberOfRow = document.getElementsByTagName("tr").length;
        var numberOfCol = document.getElementsByTagName("td").length / numberOfRow;
        // if appendtorow
        if(ar === true) {
            if(ap > numberOfRow + 1) {
                alert("추가할 위치의 값이 범위를 초과하였습니다. 다시입력해주세요.");
            }
            else {
                var tr = myt.insertRow(position-1);
                tr.style.backgroundColor = "pink"
                for(var index = 0; index < numberOfCol; index++) {
                    var td = tr.insertCell(-1);
                }
            }
        } else { // if appendColumn
            if(ap > numberOfCol + 1) {
                alert("추가할 위치의 값이 범위를 초과하였습니다. 다시입력해주세요.");
            }
            else {
                for(var index = 0; index < numberOfRow; index++) {

                    var td = document.getElementsByTagName("tr")[index].insertCell(position-1);
                    td.style.backgroundColor = "green";
                }
            }
        }
    }
}

function addContent() {
    var row_ = document.getElementById("contentRow").value;
    var col_ = document.getElementById("contentCol").value;
    var pattern = /^[0-9]+$/;
    var content_ = document.getElementById("content").value;
    var isOK = 1;
    
    if(!row_.match(pattern) && !col_.match(pattern)) {
        alert("열과 행의 값을 숫자로 입력하세요");
        isOK= 0;
    }
    else if(!col_.match(pattern)) {
        alert("열의 값을 숫자로 입력하세요");
        isOK= 0;
    }
    else if(!row_.match(pattern)) {
        alert("행의 값을 숫자로 입력하세요");
        isOK= 0;
    }

    if(content_.length === 0) {
        alert("추가할 값을 입력하세요");
        isOK= 0;
    }

    if(isOK === 1) {
        var tr = document.getElementsByTagName("tr")[parseInt(row_) - 1];
        tr.childNodes[parseInt(col_) - 1].innerHTML = content_;
    }
}
