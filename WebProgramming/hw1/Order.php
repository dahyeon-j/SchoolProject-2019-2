<?php
    echo "저장되었습니다.<br>";
    $submitData = $_POST["orderData"];
    $submit_ = explode("|||", $submitData);
    $clientId = $submit_[0];

    $clientFile = fopen("./data/".$clientId.".txt", "a");
    for($i = 1; $i < count($submit_); $i++) {
        if(strlen($submit_[$i]) !== 0) {
            fwrite($clientFile, $submit_[$i]."\n");
        }
    }
    fclose($clientFile);


   

    //$clientFile = fopen("./data/".$clientId.".txt", "r");
    $bookFile = fopen("./data/booklist.txt", "r");
    $updateData = "";

    while(!feof($bookFile)) {
        $line = fgets($bookFile);
        if(strlen($line) !== 0) {
            $tmp = explode("|", $line); // 기존의 줄을 배열로 변환
            for($i = 1; $i < count($submit_);$i++) {
                $ordered = explode("|", $submit_[$i]);
                $cmp = strcmp($tmp[0], $ordered[0]);
                if($cmp === 0) {
                    $tmp[2] -= $ordered[1];
                }
            }
            $updateData .= implode("|", $tmp);
        }
    }
    fclose($bookFile);

    $bookFile = fopen("./data/booklist.txt", "w");
    fputs($bookFile, $updateData);
    fclose($bookFile);
    //file_put_contents("./data/booklist.txt", $updateData);
?>