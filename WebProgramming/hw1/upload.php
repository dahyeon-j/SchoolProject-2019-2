<?php
    $target_dir = "./data/"; // directory of TextFile
    $uploads_dir = './uploads';
    $target_file = $target_dir . "booklist.txt";

    $imageFile = $_FILES['imageFile']['name']; // 이미지 파일의 이름
    $imageFileType = strtolower(pathinfo($imageFile,PATHINFO_EXTENSION));
    $uploadOk = 1;
    
    $nameErr = $priceErr = $quantityErr = "";

    $name = $price = $quantity = "";
    if($_SERVER["REQUEST_METHOD"] == "POST")
    {
        if (empty($_POST["name"])) {
            $nameErr = "상품 이름이 필요합니다.";
        } else {
            $name = $_POST["name"];
        }

        if (empty($_POST["price"])) {
            $priceErr = "가격이 필요합니다.";
        } else {
            $price = $_POST["price"];
        }

        if (empty($_POST["quantity"])) {
            $quantityErr = "수량이 필요합니다.";
        } else {
            $quantity = $_POST["quantity"];
        }
    }
    
    if(file_exists($uploads_dir."/".$imageFile)) {
        echo "Sorry, file already exists.";
        $uploadOk = 0;
    }

    if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif")
    {
        echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
        $uploadOk = 0;

    }

    // 이미지 추가, 텍스트 파일 추가.
    if($uploadOk == 0) {
        echo "Sorry, your file was not uploaded.";

    } else {
        move_uploaded_file( $_FILES['imageFile']['tmp_name'], "$uploads_dir/$imageFile");

        $myfile = fopen($target_file, "a") or die("Unable to open file!");
        
        $text = "$name|$price|$quantity|$imageFile";

        fwrite($myfile, "$text\r\n");
        fclose($myfile);

        echo "<script>location.href='./SaveComplete.html'</script>";
    }

   // $myfile = fopen("./data/booklist.txt", "a") or die("Unable to open file!");
?>