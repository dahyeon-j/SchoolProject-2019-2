<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>HW2</title>
    <link rel="stylesheet" href="./Calendar.css">
    <script src="Calendar.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

    <!-- add버튼을 눌렀을 시에 나타나는 모달창 -->
    <div>
        <button class="inline" onclick = "clickAddButton()" id = "addButton_">Add</button>
        <div class="inline">
            <div class="addModal" id="addModal">
                day
                <select id="mySelect">
                    <option value="Sun" slected="slected">Sun</option>
                    <option value="Mon">Mon</option>
                    <option value="Tue">Tue</option>
                    <option value="Wed">Wed</option>
                    <option value="Thu">Thu</option>
                    <option value="Fri">Fri</option>
                    <option value="Sat">Sat</option>
                </select>
                <br/>
                title <input id="title" class="right" type="text" minlength="1">
                <br/>
                description <input id="description" class="right" type="text" minlength="1">
                <br/>
                <button onclick = "clickSaveButton()">Save</button>
                <button>Cancel</button>
            </div>
        </div>


        <!-- li의 정보를 보여주는 모달창 -->
        <div class="inline">
            <div id="liModal" class="liModal"> 
                day
                <select id="liSelect" disabled="true">
                    <option value="Sun">Sun</option>
                    <option value="Mon">Mon</option>
                    <option value="Tue">Tue</option>
                    <option value="Wed">Wed</option>
                    <option value="Thu">Thu</option>
                    <option value="Fri">Fri</option>
                    <option value="Sat">Sat</option>
                </select>
                <br>
                title
                <input type="text" class="right" id="titleInfo" disabled="true">
                <br>
                description
                <input type="text" class="right" id="descriptionInfo" disabled="true">
                <br>
                <button id="editbtn" onclick="clickEditBtn()">Edit</button>
                <button id="deletebtn" onclick="clickDeleteBtn()">Delete</button>
                <button id="submitbtn" onclick="clickSubmitBtn()" disabled="true">Submit</button>
                <button id="cancelbtn" onclick="clickCancelBtn()">Cancel</button>
            </div>
        </div>

        <div class="modal01">
            <div id="modal02" class="skyblue">
                id<input name = "_id_" id="id_" class="right" type="text">
                <br/>
                password<input name="_password_" id="password_" type="password">
                <br/>
                <button class="SubmitButton" onclick="clickSubmitButton()"><a id="loginpage">Submit</a></button>
                <button class="SigninButton" onclick="clickSigninButton()">Signin</button>
                <form action="newUser.php" method="POST" id="idpass">
                    <input type="hidden" id="submitIP" name="submitIP">
                </form>
            </div>
        </div>
        <button class="right" onclick="clickLogout()">Logout</button>
        <button class="right" onclick="clickJoinButton()">Join</button>
        <div class="right">
            <?php
                if(!empty($_GET['user'])) {
                    echo $_GET['user'];
                }
            ?>
        </div>  
    </div>
    <br/>

    
    <div id="tablediv" class="displaynon">
        <table class="table" id="todolist" class="displaynon">
            <thead>
                <tr>
                    <th>Sun</th>
                    <th>Mon</th>
                    <th>Tue</th>
                    <th>Wed</th>
                    <th>Thu</th>
                    <th>Fri</th>
                    <th>Sat</th>
                </tr>
            </thead>
            <tbody draggable="false">
                <tr>
                    <td id="SunTd" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="false">
                        <!-- Sun -->
                        <ul id="SunUl" draggable="false" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            $isEmpty = true;
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Sun.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Sun.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                    <td id="MonTd" ondrop="drop(event)" ondragover="allowDrop(event)" >
                        <!-- Mon -->
                        <ul id="MonUl" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Mon.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Mon.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                    <td id="TueTd" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="false">
                        <!-- Tue -->
                        <ul  id="TueUl" draggable="false" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Tue.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Tue.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                    <td id="WedTd" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="false">
                        <!-- Wed -->
                        <ul id="WedUl" draggable="false" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Wed.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Wed.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                    <td id="ThuTd" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="false">
                        <!-- Thu -->
                        <ul id="ThuUl" draggable="false" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Thu.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Thu.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                    <td id="FriTd" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="false">
                        <!-- Fri -->
                        <ul id="FriUl" draggable="false" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Fri.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Fri.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                    <td id="SatTd" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="false">
                        <!-- Sat -->
                        <ul id="SatUl" draggable="false" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <?php
                            if(!empty($_GET['user'])) {
                                $user = $_GET['user'];
                                $filename = './data/'.$user.'_Sat.txt';
                                if(file_exists('./data/'.$_GET['user'].'_Sat.txt')) {
                                    $fp = fopen($filename, "r");
                                    while(!feof($fp)) {
                                        $line = fgets($fp);
                                        $split = explode("|", $line);
                                        if(strlen($line) != 0) {
                                            echo '<li id="' . $line . '" draggable="true" onclick="clickLI(this)" ondragstart="drag(event)">'. $split[1] .'</li>';
                                            $isEmpty = false;
                                        }
                                    }
                                    fclose($fp);
                                }
                            }
                            ?>
                            
                        </ul>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>  

    <?php
        if(!empty($_GET['user'])) {
            echo '<script>document.getElementById("tablediv").style.display = "block";</script>';
        }
    ?>

    <?php
        if(!empty($_GET['user']) && $isEmpty) {
            echo '<script>alert("저장한 데이터가 없습니다");</script>';
        }
    ?>
    <form id="newSchedule" action="newSchedule.php" method="POST">
        <input type="hidden" id="sendid" name="sendid">
        <input type="hidden" id="sendday" name="sendday">
        <input type="hidden" id="senddata" name="senddata">
    </form>

    <form id="UpdateData" action="UpdateData.php" method="POST">
        <input type="hidden" id="UserId_" name="UserId_">
        <input type="hidden" id="Sun_" name="Sun_">
        <input type="hidden" id="Mon_" name="Mon_">
        <input type="hidden" id="Tue_" name="Tue_">
        <input type="hidden" id="Wed_" name="Wed_">
        <input type="hidden" id="Thu_" name="Thu_">
        <input type="hidden" id="Fri_" name="Fri_">
        <input type="hidden" id="Sat_" name="Sat_">
    </form>

</body>
</html>