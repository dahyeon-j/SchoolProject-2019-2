function doSelectAll() {
    var selectedItem = document.getElementsByClassName("check");
    if(document.getElementById("selectAll").checked)
    {
        for(var i = 0; i < selectedItem.length; i++)
        {
            selectedItem[i].checked = true;
        }
        
        var selected = document.getElementById("printselected");
        printNumberOfSelectedItem();
    }
    if(!document.getElementById("selectAll").checked) {
        for(var i = 0; i < selectedItem.length; i++)
        {
            selectedItem[i].checked = false;
        }
        
        var selected = document.getElementById("printselected");
        printNumberOfSelectedItem();
    }
    

}

function printNumberOfSelectedItem()
{
    var selectedItem = document.getElementsByClassName("check");
    var cnt = 0;
    for(var i=0; i < selectedItem.length; i++) {
		if(selectedItem[i].checked) cnt++;
    }
    var selected = document.getElementById("printselected");
    selected.innerHTML = "총 " + cnt + "개 상품 선택";
    changeSums();
    isAllChecked();
}

function removeSelected() {
    var selectedItem = document.getElementsByClassName("check");
    for(var i = selectedItem.length - 1; 0 <= i; i--)
    {
        if(selectedItem[i].checked) selectedItem[i].parentElement.parentElement.remove();
    }
    printNumberOfSelectedItem();
}
// 수량을 변경했을 시 실행되는 함수

function changeQuantity() {
    var prices = document.getElementsByName("price");
    var changed = 0;
    for(var i = 0; i < prices.length; i++) {
        var change = parseInt(prices[i].nextSibling.childNodes[0].value);
        var price = parseInt(prices[i].innerHTML);
        var originalValue = parseInt(prices[i].nextSibling.nextSibling.innerHTML);
        var changeValue = parseInt(change * price);

        if(originalValue !== changeValue) {
            prices[i].previousSibling.previousSibling.previousSibling.childNodes[0].checked = true;
            prices[i].nextSibling.nextSibling.innerHTML = changeValue;
            changed++;
        }
    }
    if(changed > 0) {
        printNumberOfSelectedItem();
    }
    else {
        alert("수량이 변경되지 않았습니다");
    }

    isAllChecked();

}


function changeSums() {
    var selectedItem = document.getElementsByClassName("check");
    var sumItem = document.getElementsByName("sum");
    var sums = 0;
    for(var i = 0; i < selectedItem.length; i++)
    {
        if(selectedItem[i].checked === true) {
            sums += parseInt(sumItem[i].innerHTML);
        }
    }
    document.getElementById("sums").innerHTML = sums;

}

function validOrder() {

    var checkId = false;
    var checkCheck = false;
    var validId = /^[A-Za-z]+$/;
    var inputId = document.getElementById("clientID").value;
    
    if(inputId.match(validId)) {
        checkId = true;
    }

    var selectedItem = document.getElementsByClassName("check");

    var cnt = 0;
    for(var i = 0; i < selectedItem.length; i++){
        if(selectedItem[i].checked === true) {
            cnt++;
        }
    }
    if(cnt > 0) {
        checkCheck = true;
    }

    var submitData = "";
    var titles = document.getElementsByClassName("title");
    var quantities = document.getElementsByName("quantity");
    var fin = document.getElementById("final");
    if(checkId === false && checkCheck === false) {
        alert("아이디는 영문자로 입력하시고, 체크박스도 선택해주세요.");
    } else if(checkId === false) {
        alert("아이디는 영문자로 입력해주세요.");
    } else if(checkCheck === false) {
        alert("체크 박스를 선택해주세요.");
    } else {
        var submitData = "";
        submitData = document.getElementById("clientID").value;

        for(var i = 0; i < selectedItem.length; i++){
            if(selectedItem[i].checked === true) {
                submitData += ("|||" + titles[i].innerHTML + "|" + quantities[i].value);
            }
        }

        document.getElementById("orderData").value = submitData;

        fin.submit();
    }
}

function isAllChecked() {
    var check_ = document.getElementsByClassName("check");
    var cc = true;
    for(var i = 0; i < check_.length; i++) {
        if(check_[i].checked !== true) {cc = false;}
    }

    if(cc === true) {
        document.getElementById("selectAll").checked = true;
    }
}