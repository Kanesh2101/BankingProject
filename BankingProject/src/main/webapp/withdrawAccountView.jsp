<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KE Bank</title>
</head>
<body>

 
     

    <div class="container">
        <div class="row">
 <h1>Please choose your transaction below</h1>
 	<form action = "accountView">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Back to Account Management"/>
               </td>
            </tr>
         </table>  
      </form>
      
     <form action = "backToHome">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Back to HomePage"/>
               </td>
            </tr>
         </table>  
      </form>
      
	 <h1> WITHDRAW ACCOUNT PAGE</h1>
    <br><br>  

	
	<h2>Withdraw Cash</h2>
	<form action="withdrawCash">
			Account Number : <input type="text" name="AccountNumber"><br><br>
			
			Amount : <input type="text" name="Ammount"><br><br>
	
		<input type="submit"><br>
	</form>
	
	
	
	<br><br>

</div>
</div>
	
	

</body>
</html>