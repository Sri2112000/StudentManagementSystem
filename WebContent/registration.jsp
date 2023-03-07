<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
   body
   {  
   text-align:center;
   text-size:250px;
   }
</style>
</head>
<body>
	<table align="center">
		<h1>Student Registration Page</h1>
		<form action="My" method="post" align="center">
					<lable for="tbName">Enter Name : </lable>
					<input type="name"  name="tbName" id="tbName"/>
					<br/>
					<lable for="tbEmail">Enter Email : </lable>
					<input type="email"  name="tbEmail" id="tbEmail"/>
					<br/>
					<lable for="tbPass">Enter Password : </lable>
					<input type="text"  name="tbPass" id="tbPass"/>
					<br/>
					<lable for="">Enter State: </lable>
					<select name="ddlState">
					<option value="Select">----Select-----</option>
					<option value="Karanataka">Karnataka</option>
					<option value="Goa">Goa</option>
					<option value="Delhi">Delhi</option>
					<option value="Telangana">Telangana</option>
					<option value="Kerala">Kerala</option>
					<option value="Maharastra">Maharastra</option>
					<option value="Jammu">JammuAndKashmir</option>
					<option value="Gujarath">Gujarath</option>
					</select>
					<br/>
					<input type="submit" value="Insert" name="crud"/>
					<input type="submit" value="Update" name="crud"/>
					<input type="submit" value="Delete" name="crud"/>
					<input type="submit" value="ShowAll" name="crud"/>
		</form>
	</table>
</body>
</html>