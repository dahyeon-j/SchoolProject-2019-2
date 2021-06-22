var login = false;
var myid;
var tg;

function clickJoinButton() {
    document.getElementById("modal02").style.display = "block";
}

function checkValidation() {
    var validId = /^([A-Za-z0-9]){6,15}$/;
    var validPassword = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

    var inputId = document.getElementById("id_").value;
    var inputPassword = document.getElementById("password_").value;


    if (!inputId.match(validId) || !inputPassword.match(validPassword)) {
        if (confirm("아이디 또는 패스워드의 입력양식을 체크해주세요") == true) {
            document.getElementById("modal02").style.display = "none";
            return false;
        }
    }
    return true;
}


function clickSubmitButton() {
    if (checkValidation()) {
        var inputId = document.getElementById("id_").value;
        var inputPassword = document.getElementById("password_").value;

        var xhttp;
        xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var list = this.responseText.split("\n");
                for (var i = 0; i < list.length; i++) {
                    if (list[i].length != 0) {
                        var tmp = list[i].split("|");
                        if ((tmp[0] === inputId) && (tmp[1].trim() === inputPassword)) {
                            login = true;
                            myid = inputId;
                            //localStorage.setItem("myid", inputId);
                            document.getElementById("tablediv").style.display = "block";
                            var newpage = "./Calendar.php?user=" + inputId;
                            window.location = newpage;
                            sessionStorage.setItem('myid', inputId);
                            document.getElementById("tablediv").style.display = "block";
                            //window.open(newpage);
                            break;
                        }
                    }
                }
                document.getElementById("modal02").style.display = "none";
            }
        }
        xhttp.open("POST", "./data/person.txt", true);
        xhttp.send();
    }
}

function clickSigninButton() {
    var ok = false;
    var inputId = document.getElementById("id_").value;
    var inputPassword = document.getElementById("password_").value;
    if (checkValidation()) {
        ok = true;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "./data/person.txt", true);
        xhttp.send();

        var ok = true;
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var list = this.responseText.split("\n");
                for (var i = 0; i < list.length; i++) {
                    if (list[i].length != 0) {
                        var tmp = list[i].split("|");
                        if (tmp[0] === inputId) {
                            alert("중복된 아이디");
                            ok = false;
                        }
                    }
                    document.getElementById("modal02").style.display = "none";
                }
                if (ok === true) {
                    document.getElementById("submitIP").value = inputId + "|" + inputPassword + "\n";
                    alert("회원 가입 완료");
                    document.getElementById("idpass").submit();
                }
            }
        };
    }
}

function clickAddButton() {
    if (sessionStorage.getItem("myid") == null) {
        alert("추가하기 위해 로그인 해주세요");
        return;
    }
        
    var addButton = document.getElementById("addButton_");
    document.getElementById("addModal").style.display = "block";
}

function clickSaveButton() {
    var select = document.getElementById("mySelect");
    var day = select.options[select.selectedIndex].text;

    var title = document.getElementById("title").value;
    var description = document.getElementById("description").value;
    if(title.length == 0 || description.length == 0) {
        alert("title과 description은 반드시 입력해 주세요");
    } else {
        alert("저장되었습니다.");
        var d = new Date();
        var id = "" + d.getMonth() + d.getDay() + d.getHours() + d.getMinutes() +d.getSeconds()  + "|" + title + "|" + description + "\n";
        var user = sessionStorage.getItem("myid");
        document.getElementById("sendid").value = user;
        document.getElementById("sendday").value = day;
        document.getElementById("senddata").value = id;
        document.getElementById("newSchedule").submit();
    }
}


function allowDrop(ev) {
    ev.preventDefault();
}
  
function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}
  
function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");

    var day_ = "";
    var data_ = "";
    var user_ = "";
    if(ev.target.tagName === "LI") {
        var li = document.getElementById(data).outerHTML;
        if(document.getElementById(data).id != ev.target.id) {
        document.getElementById(data).remove();
        ev.target.insertAdjacentHTML('beforebegin', li);// 형제요소 전에 생성
        //alert(ev.target.parentNode.id.substring(0,3));
        //document.getElementById(ev.target.parentNode.id.substring(0,3) + "UL");
        }
    } else if(ev.target.tagName === "TD"){
        var children = ev.target.childNodes;
        //alert(children[3].nodeName);
        children[3].appendChild(document.getElementById(data));
        //alert(ev.target.id.substring(0,3));
    } else if(ev.target.tagName === "UL") {
        ev.target.appendChild(document.getElementById(data));
        //alert(ev.target.id.substring(0,3));
    }

    updateData();

}

function updateData() {
    document.getElementById("UserId_").value = sessionStorage.getItem("myid");

    var Sun = "";
    for(var i = 0; i < document.getElementById("SunUl").getElementsByTagName("LI").length; i++) {
        Sun += (document.getElementById("SunUl").getElementsByTagName("LI")[i].id +"+");
        
    }
    document.getElementById("Sun_").value = Sun;

    var Mon = "";
    for(var i = 0; i < document.getElementById("MonUl").getElementsByTagName("LI").length; i++) {
        Mon += (document.getElementById("MonUl").getElementsByTagName("LI")[i].id + "+");
    }
    document.getElementById("Mon_").value = Mon;

    var Tue = "";
    for(var i = 0; i < document.getElementById("TueUl").getElementsByTagName("LI").length; i++) {
        Tue += (document.getElementById("TueUl").getElementsByTagName("LI")[i].id + "+");
        
    }
    document.getElementById("Tue_").value = Tue;

    var Wed = "";
    for(var i = 0; i < document.getElementById("WedUl").getElementsByTagName("LI").length; i++) {
        Wed += (document.getElementById("WedUl").getElementsByTagName("LI")[i].id + "+");
    
    }
    document.getElementById("Wed_").value = Wed;

    var Thu = "";
    for(var i = 0; i < document.getElementById("ThuUl").getElementsByTagName("LI").length; i++) {
        Thu += (document.getElementById("ThuUl").getElementsByTagName("LI")[i].id + "+");
    }
    document.getElementById("Thu_").value = Thu;

    var Fri = "";
    for(var i = 0; i < document.getElementById("FriUl").getElementsByTagName("LI").length; i++) {
        Fri += (document.getElementById("FriUl").getElementsByTagName("LI")[i].id + "+");
    }
    document.getElementById("Fri_").value = Fri;

    var Sat = "";
    for(var i = 0; i < document.getElementById("SatUl").getElementsByTagName("LI").length; i++) {
        Sat = (document.getElementById("SatUl").getElementsByTagName("LI")[i].id + "+");
    }
    document.getElementById("Sat_").value = Sat;

    document.getElementById("UpdateData").submit();
}

// 테이블을 감춤. li를 삭제.
// 로컬 storage 삭제.
function clickLI(target) {
    document.getElementById("liModal").style.display = "block";
    var info = target.id.split("|");
    var day = target.parentNode.id.substring(0, 3);
    document.getElementById("liSelect").value = day;
    document.getElementById("titleInfo").value = info[1];
    document.getElementById("descriptionInfo").value = info[2];
    tg = target.id;
}

function clickSubmitBtn() {
    var select = document.getElementById("liSelect");
    var day_ = select.options[select.selectedIndex].text;
    var title_ = document.getElementById("titleInfo").value;
    var description_ = document.getElementById("descriptionInfo").value;

    var tmp = tg.split("|");
    document.getElementById(day_ + "Ul").appendChild(document.getElementById(tg));
    document.getElementById(tg).id = tmp[0]+"|" + title_+"|" + description_;

    alert("변경되었습니다.");
    updateData();

}

function clickCancelBtn() {
    document.getElementById("liSelect").disabled = true;
    document.getElementById("titleInfo").disabled = true;
    document.getElementById("descriptionInfo").disabled = true;
    document.getElementById("submitbtn").disabled = true;
    document.getElementById("editbtn").disabled = false;
    document.getElementById("deletebtn").disabled = false;
    document.getElementById("liModal").style.display = "none";
}

function clickEditBtn() {
    document.getElementById("liSelect").disabled = false;
    document.getElementById("titleInfo").disabled = false;
    document.getElementById("descriptionInfo").disabled = false;
    document.getElementById("submitbtn").disabled = false;
    document.getElementById("editbtn").disabled = true;
    document.getElementById("deletebtn").disabled = true;
}

function clickDeleteBtn() {
    document.getElementById(tg).remove();
    alert("삭제되었습니다.");
    document.getElementById("liModal").style.display = "none";
    updateData();
}

function clickLogout() {
    sessionStorage.clear();
    window.location = "./Calendar.php";
}