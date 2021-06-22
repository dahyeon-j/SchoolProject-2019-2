<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>고객 주문</title>
    <link rel="stylesheet" href="Client.css">
    <script src="./Client.js"></script>
  </head>
  <body> 
    <h1>도서 주문 페이지</h1>
    
    <p>
      구매자 아이디:<input type="text" id="clientID" name="clientID">
    </p>
    <p><input type="checkbox" id="selectAll" onclick="doSelectAll()"> 모두선택</p>
    <table>
      <thead>
        <tr>
          <th>선택</th>
          <th>상품명</th>
          <th>미리보기</th>
          <th>정가</th>
          <th>수량</th>
          <th>합계</th>
        </tr> 
      </thead>
      <tbody>
      <?php
          $reader = fopen("./data/booklist.txt", "r");

          while(!feof($reader))
          {
              $data = fgets($reader);
              if(strlen($data) != 0) {
                $_data = explode('|', $data);
                $result = '<tr>';
                $result .= '<td><input type="checkbox" class = "check" name = "'.$_data[0].'" onclick="printNumberOfSelectedItem()"></td>';
                $result .= ('<td class="title">'.$_data[0].'</td>');
                $result .= ('<td><button><a href="./uploads/'. $_data[3] .'">미리보기</a></button></td>');
                $result .= ('<td name="price">'.$_data[1].'</td>');
                $result .= ('<td><input type="text" name="quantity" value='.$_data[2].'><button type="button" onclick="changeQuantity()">변경</button></td>');
                $result .= ('<td name="sum">'.$_data[1]*$_data[2].'</td>');
                $result .= '</tr>';
              echo $result;
            }
          }

          fclose($reader);
          
        ?>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="5"><b>선택한 총 상품 금액</b> </td>
          <td id = "sums">0</td>
        </tr>
      </tfoot>

      
    </table>
   
    <p id="printselected">
    총 0개 상품 선택
    </p>

    <button onclick = "removeSelected()">삭제하기</button>
          
    <input type="button" onclick = "validOrder()"  value="주문하기" >
    

    <form id="final" method="post" action="./Order.php" >
    <input type="hidden" name= "orderData" id="orderData" value=""/>
    </form>
  </body>
</html>