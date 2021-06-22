<?php
    echo "저장되었습니다.";
    $submitData = $_POST["submitData"];
    file_put_contents("./score.txt", $submitData);
?>