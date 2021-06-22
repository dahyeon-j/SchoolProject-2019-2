<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>성적 처리 페이지</title>
    <link rel="stylesheet" href="grade.css">
    <script src="./grade.js"></script>
</head>
<body>
    <h1>성적 처리 페이지</h1>
    <table>
        <thead>
            <th>과목명</th><th>학점</th><th>점수</th><th>출석</th><th>소계</th>
        </thead>
        <tbody>
        
            <?php
                $reader = fopen("./score.txt", "r");
                $total = 0;
                $numberOfSubjects = 0;
                while(!feof($reader)) {
                    $data = fgets($reader);
                    
                    $grades = array("A", "B", "C", "D","F");
                    if(strlen($data) != 0) {
                        $data_ = explode('|', $data);
                        $numberOfSubjects += $data_[1];
                        $result = '';
                        $result .= '<tr>';
                        $result .= ('<td class="nm">'.$data_[0].'</td>');
                        $result .= ('<td class="gr">'.$data_[1].'</td>');
                        $result .= '<td><select class="slection" onchange="changeGrade(this)">';
                        for($i = 0; $i < 5; $i++) {
                            $result .= '<option value="'.$data_[2].'"';
                            if($grades[$i] === $data_[2]) {
                                $result .= 'selected';
                            }
                            $result .= '>'.$grades[$i].'</option>';
                        }
                        $result .= '</select></td>';
                        $result .= ('<td><input class="attendance" value="'.$data_[3].'"></td>');
                        $subtotal = 0;
                        switch($data_[2]) {
                            case "A":
                            $subtotal = 4 * (int)$data_[1];
                            break;
                            case "B":
                            $subtotal = 3 * (int)$data_[1];
                            break;
                            case "C":
                            $subtotal = 2 * (int)$data_[1];
                            break;
                            case "D":
                            $subtotal = 1 * (int)$data_[1];
                            break;
                        }
                        $total += $subtotal;
                        $result .= ('<td class="sub">'.$subtotal.'</td>');
                        $result .= '</tr>';
                        echo $result;
                    }
                }

                $grade;
                if($total / $numberOfSubjects >= 4.0) {
                    $grade = "A";
                } else if($total / $numberOfSubjects >= 3.0) {
                    $grade = "B";
                } else if($total / $numberOfSubjects >= 2.0) {
                    $grade = "C";
                } else if($total / $numberOfSubjects >= 1.0) {
                    $grade = "D";
                } else {
                    $grade = "F";
                }
                
                
                fclose($reader);
                
            ?>
        </tbody>
        <tfoot>
            <tr><th colspan="4">총 계</th><td id="TotalSum"><?php echo $total; ?></td></tr>
            <tr><th colspan="4">총 평점</th><td id="TotalGrade"><?php echo $grade; ?></td></tr>
        </tfoot>
    </table>
    <br/>
    <button onclick = "checkValidation()">저장하기</button>

    <form id="final" method = "post" action="./store.php">
        <input type="hidden" name="submitData" id="submitData" value = ""/>
    </form>
</body>
</html>