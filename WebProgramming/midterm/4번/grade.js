function changeGrade(target) {
   var changed = target.options[target.selectedIndex].text;
   var mutiplier = 0;
    if(changed === "A") {
        mutiplier = 4;
    } else if(changed === "B") {
        mutiplier = 3;
    } else if(changed === "C") {
        mutiplier = 2;
    } else if(changed === "D") {
        mutiplier = 1;
    }
    var mutiplicand = target.parentElement.previousSibling.innerHTML;
    var changedValue = mutiplier * parseInt(mutiplicand);
    target.parentElement.nextSibling.nextSibling.innerHTML = changedValue;
    changeTotal();
}

function changeTotal() {
    var ar = document.getElementsByClassName("sub");
    var gr = document.getElementsByClassName("gr");
    var sum = 0;
    var sumofgr = 0;
    for(var i = 0; i < ar.length; i++) {
        sum += parseInt(ar[i].innerHTML);
        sumofgr += parseInt(gr[i].innerHTML);
    }

    document.getElementById("TotalSum").innerHTML = sum;
    
    sum /= sumofgr;
    
    if(sum >= 4.0) {
        document.getElementById("TotalGrade").innerHTML = "A";
    } else if(sum >= 3.0) {
        document.getElementById("TotalGrade").innerHTML = "B";
    } else if(sum >= 2.0) {
        document.getElementById("TotalGrade").innerHTML = "C";
    } else if(sum >= 1.0) {
        document.getElementById("TotalGrade").innerHTML = "D";
    } else {
        document.getElementById("TotalGrade").innerHTML = "F";
    }
}

function checkValidation() {
    var nm = document.getElementsByClassName("nm");
    var gr = document.getElementsByClassName("gr");
    var se = document.getElementsByClassName("slection");
    var at = document.getElementsByClassName("attendance");
    var OK = 1;


    //alert(se[0].options[se[0].selectedIndex].text);
    for(var i = 0; i < gr.length; i++) {
        if(parseInt(gr[i].innerHTML) * 15 < at[i].value) {
            alert("최대 시수시간을 초과했습니다.");
            OK = 0;
            break;
        }
    }

    for(var i = 0; i < gr.length; i++) {
        if(se[i].options[se[i].selectedIndex].text !== "F") {
            if(at[i].value < parseInt(gr[i].innerHTML) * 15 * 0.75) {
                alert("D이상은 해당교육 시수의 3/4이상을 출석해야 합니다.");
                OK = 0;
                break;
            }
        }
    }

    var data = "";
    if(OK === 1) {
        for(var i = 0; i < gr.length; i++) {
            data += (nm[i].innerHTML+ "|" + gr[i].innerHTML + "|" + se[i].options[se[i].selectedIndex].text + "|" + at[i].value + "\n");
        }
        document.getElementById("submitData").value = data;
        document.getElementById("final").submit();
    }

}
