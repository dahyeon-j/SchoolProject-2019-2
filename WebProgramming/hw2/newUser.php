<?php
    $data = $_POST["submitIP"];
    // $id = $data.explode("|");

    $inputfile = fopen("./data/person.txt", "a");
    fwrite($inputfile, $data);
    fclose($inputfile);
    

    $prevPage = $_SERVER['HTTP_REFERER'];
    header('location:'.$prevPage);
?>