<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Search an Account</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="viewAccount.app" method="get">
<div>
<table cellspacing="30" align="center" border="2">
<tr>
<th colspan="6" height="35"><h2>Money Money Bank</h2></th>
</tr>
<tr>
<th colspan="6" > <input type="number" name="typedAccount" placeholder="Enter Account Number" required="required"></th>
</tr>
<tr>
<th colspan="6" height="40"><input type="submit" value="Search"></th>
</tr>
</table>
</div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>