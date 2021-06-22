<?php

    echo "저장을 성공하였습니다.";
    $submitData = $_POST["data"];
    $data_ = explode("||", $submitData);

    $file = fopen("./data.txt", "a");

    for($i = 0; $i < 5; $i++) {
        fputs($file, $data_[$i] . "\n");
    }

    fclose($file);
?>