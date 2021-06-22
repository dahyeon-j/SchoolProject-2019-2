function isRightForm() {
    var isOK = 1;

    if(document.getElementById("aid").value.length === 0) {
        alert("아이디를 입력해 주세요!");
        isOK = 0;
    }
    var pattern1 = /^[ㄱ-힣a-zA-Z]+$/;

    if(!document.getElementById("nname").value.match(pattern1)) {
        alert("이름은 문자만 입력해 주세요!");
        isOK = 0;
    }

    var pattern2 = /^[0-9]+$/;
    if(!document.getElementById("phoneNumber").value.match(pattern2)) {
        alert("전화번호는 숫자만 입력해 주세요!");
        isOK = 0;
    }

    var pattern2 = /^[0-9]+$/;
    if(!document.getElementById("phoneNumber").value.match(pattern2)) {
        alert("전화번호는 숫자만 입력해 주세요!");
        isOK = 0;
    }

    if(document.getElementById("g").checked === false && document.getElementById("b").checked === false) {
        alert("성별을 선택하세요!");
        isOK = 0;
    }

    var numberOfChecked = 0;
    var checkBoxes = document.getElementsByName("check");

    for(var i = 0; i < checkBoxes.length; i++) {
        if(checkBoxes[i].checked === true) {
            numberOfChecked++;
        }
    }

    if(numberOfChecked <= 1) {
        alert("관심분야는 두 개 이상 고르세요!");
        isOK = 0;
    }

    
    if(isOK === 1) {
        var submitData = "id:" +document.getElementById("aid").value;
        submitData += ("||name:" + document.getElementById("nname").value);
        submitData += ("||ph:" + document.getElementById("phoneNumber").value);
        if(document.getElementById("g").checked === true) {
            submitData += "||gender:female||favtopic:";
        } else {
            submitData += "||gender:male||favtopic:";
        }

        var array = new Array();
        if(checkBoxes[0].checked === true) {
            array.push("movie");
        }
        if(checkBoxes[1].checked === true) {
            array.push("music");
        }
        if(checkBoxes[2].checked === true) {
            array.push("game");
        }
        if(checkBoxes[3].checked === true) {
            array.push("coding");
        }

        submitData += array.join("/");

        
        document.getElementById("data").value = submitData;

        document.getElementById("sub").submit();
    }

}