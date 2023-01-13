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
 <div class="col-12">
  <form action = "accountView">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Back to Account Management"/>
               </td>
            </tr>
         </table>  
      </form>
     
      <div class="col-4">
     <form action = "backToHome">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Back to HomePage"/>
               </td>
            </tr>
         </table>  
      </form>
      </div>
     </div>
	 <h1> DISPLAY ACCOUNT INFO PAGE</h1>
    <br><br>  

	

<h4>Customer Name : ${account.customer.name}</h4>
<h4>Customer Id : ${account.customer.id}</h4>
<h4>Account status : ${account.accountStatus == 1 ? 'Active' : 'Closed'}</h4>
<h4>Account Balance : RM ${account.ammount}</h4> 





	
	<br><br>

</div>
</div>
	
	

</body>
</html>
