<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="alfa" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="home.jsp" method="get">
<div>
<table cellspacing="20" align="center" border="2">
<tr>
<th colspan="6" height="35"><h2>Successfully Transfered Amount ${sessionScope.amountInTransfer} from Account Number ${sessionScope.accountInWithdrawTransfer} to Account Number ${sessionScope.accountInDepositTransfer}</h2></th>
</tr>
<tr>
<th colspan="6" height="40"><input type="submit" value="Home"></th>
</tr>
</table>
</div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>