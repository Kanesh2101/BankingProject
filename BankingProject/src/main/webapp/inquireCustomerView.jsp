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
                  <input type = "submit" value = "Account Management"/>
               </td>
            </tr>
         </table>  
      </form>
      
      <form action = "createCustomerView">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Create Customer"/>
               </td>
            </tr>
         </table>  
      </form>
      
       <form action = "inquireCustomerView">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Inquire Customer"/>
               </td>
            </tr>
         </table>  
      </form>
      

 <h1> INQUIRE CUSTOMER PAGE</h1>
    <br><br>  
	
	<h2>Inquire Customer</h2>
	<form action="getCustomer">
		Customer Name : <input type="text" name="Name"><br><br>
		
		<input type="submit"><br>
	</form>
	
	
	
	
	
	<br><br>

</div>
</div>
	
	

</body>
</html>