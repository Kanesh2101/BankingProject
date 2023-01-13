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
  <div class="col-4">
 	<form action = "customerView">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Back to Customer Management"/>
               </td>
            </tr>
         </table>  
      </form>
     </div>
     
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
	 <h1> DISPLAY CUSTOMER INFO PAGE</h1>
    <br><br>  

	

<h4>Customer Name : ${customer.name}</h4>
<h4>Customer Id : ${customer.id}</h4>
<h4>Customer Email : ${customer.email}</h4>
	
	
	
	
	<br><br>

</div>
</div>
	
	

</body>
</html>
