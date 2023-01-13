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
      

 	<h1> CREATE ACCOUNT PAGE</h1>
    <br><br>  
    
    
	<h2>Create Account</h2>
	<form action="createAccount">
		Customer Name : <input type="text" name="AccountName"><br><br>
		<input type="radio" id="savings" name="AccountType" value="Savings Account">
		<label for="html">Savings Account</label><br>
		<input type="radio" id="fixed" name="AccountType" value="Fixed Deposit">
		<label for="css">Fixed Deposit</label><br><br>
		Amount : <input type="text" name="Ammount"><br><br>
		<input type="submit"><br>
	</form>
	
	
	<br><br>

</div>
</div>
	
	

</body>
</html>