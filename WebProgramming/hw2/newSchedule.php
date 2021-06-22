<?php
    $filename = "./data/" . $_POST["sendid"] . "_" . $_POST["sendday"] . ".txt";
    $data = $_POST["senddata"];
    chmod($filename,0777);
    $fp = fopen($filename, "a");
    fputs($fp, $data);
    fclose($fp);

    $prevPage = $_SERVER['HTTP_REFERER'];
    header('location:'.$prevPage);
?>