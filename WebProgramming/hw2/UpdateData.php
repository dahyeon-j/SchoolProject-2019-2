<?php
    $Id = $_POST["UserId_"];
    
    $Sun = explode("+", $_POST["Sun_"]);
    $Mon = explode("+", $_POST["Mon_"]);
    $Tue = explode("+", $_POST["Tue_"]);
    $Wed = explode("+", $_POST["Wed_"]);
    $Thu = explode("+", $_POST["Thu_"]);
    $Fri = explode("+", $_POST["Fri_"]);
    $Sat = explode("+", $_POST["Sat_"]);

        $filename = "./data/" . $Id . "_Sun.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Sun) - 1; $i++) {
            fputs($fp, $Sun[$i]);
        }
        fclose($fp);

        $filename = "./data/" . $Id . "_Mon.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Mon) - 1; $i++) {
            fputs($fp, $Mon[$i]);
        }
        fclose($fp);

        $filename = "./data/" . $Id . "_Tue.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Tue) - 1; $i++) {
            fputs($fp, $Tue[$i]);
        }
        fclose($fp);

        $filename = "./data/" . $Id . "_Wed.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Wed) - 1; $i++) {
            fputs($fp, $Wed[$i]);
        }
        fclose($fp);

        $filename = "./data/" . $Id . "_Thu.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Thu) - 1; $i++) {
            fputs($fp, $Thu[$i]);
        }
        fclose($fp);        

        $filename = "./data/" . $Id . "_Fri.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Fri) - 1; $i++) {
            fputs($fp, $Fri[$i]);
        }
        fclose($fp);

        $filename = "./data/" . $Id . "_Sat.txt"; 
        chmod($filename,0777);
        $fp = fopen($filename, "w");
        fclose($fp);

        $fp = fopen($filename, "a");
        for($i = 0; $i < count($Sat) - 1; $i++) {
            fputs($fp, $Sat[$i]);
        }
        fclose($fp);

    $prevPage = $_SERVER['HTTP_REFERER'];
    header('location:'.$prevPage);

?>