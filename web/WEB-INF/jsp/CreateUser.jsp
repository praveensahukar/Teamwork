<%-- 
    Document   : Login
    Created on : 12 Apr, 2017, 8:31:39 PM
    Author     : Administrator
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="icon" href="Network-Security.png" type="image/x-icon">
<script src="jquery-1.12.4.js"></script>
<script src="canvasjs.min.js"></script>
<script src="jquery-2.1.1.js"></script>
<script src="jquery-ui.min.js"></script>
<script src="jquery.dataTables.min.js"></script>
<script src="jquery.min.js"></script>
<script src="jquery1.min.js"></script>
<script src="prefixfree.min.js"></script>

<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" href="jquery.dataTables.min.css">
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #a6a6a6;
    width:1500px;
   
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #b30000;
}

.active {
    background-color: #cc0000;
}
</style>
<style>

@import url(http://fonts.googleapis.com/css?family=Roboto:400,100);

body {

	background-image: url("grey.jpg");
  background-repeat: repeat-y;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  font-family: 'Roboto', sans-serif;
}

.login-card {
  padding: 40px;
  width: 1420px;
  height: 550px;
  background-color: white;
  margin: 0 auto 10px;
  border-radius: 2px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  overflow: hidden;
}

.login-card h1 {
  font-weight: 1;
  text-align: center;
  font-size: 2.3em;
}

.login-card input[type=submit] {
  width: 200px;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}

.login-card select[type=submit] {
  width: 20%;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}


.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 300px;
  margin-bottom: 10px;
  -webkit-appearance: none;
  background: #fff;
  border: 1px solid #d9d9d9;
  border-top: 1px solid #c0c0c0;
  /* border-radius: 2px; */
  padding: 0 8px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
}

.login-card input[type=text]:hover, input[type=password]:hover {
  border: 2px solid #b9b9b9;
  
  border-top: 5px solid #a0a0a0;
  -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
}

.login {
  text-align: center;
  font-size: 14px;
  font-family: 'Arial', sans-serif;
  font-weight: 700;
  height: 36px;
  padding: 0 8px;
/* border-radius: 3px; */
/* -webkit-user-select: none;
  user-select: none; */
}

.login-submit {
  /* border: 1px solid #3079ed; */
  width: 300px;
  border: 0px;
  height: 38px;
  
  color: #fff;
  margin-bottom: 10px;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #a6a6a6;
  padding: 0 8px;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

.login-submit:hover {
  /* border: 1px solid #2f5bb7; */
  border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #ff8080;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
}

.login-card a {
  text-decoration: none;
  color: #666;
  font-weight: 400;
  text-align: center;
  display: inline-block;
  opacity: 0.6;
  transition: opacity ease 0.5s;
}

.login-card a:hover {
  opacity: 1;
}

.login-help {
  width: 100%;
  text-align: center;
  font-size: 12px;
}



table {
    border-collapse: collapse;
    width: 70%;
}

th, td {
    font-size: 1.0em;
    padding: 8px;
    font-family: 'Roboto', sans-serif;
    color: #cd0a0a;
    font-weight:bolder;
}

tr:nth-child(even){background-color: #F7F7F7}

th {
    background-color: #a6a6a6;
    color: white;
}
.error {
color: red;
font-style: italic;
}
</style>
<title>Add New User</title>
</head>
    <body>
    
   <%@include file="Header.jsp" %>   
   
        <div class="login-card">
	   <div align="left">  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Add New User</h2></div>

	   <form:form action="CreateUser.do" method="POST" modelAttribute="UserM">
<table border="0">
   
<tr>
    <td align="right"><b>User Name :</b></td>
    <form:errors path="username" cssClass="error"/><br>
    <td>
        <form:input placeHolder="Enter the Username"  path="username" htmlEscape="true" autocomplete="false" require="email"/>
    </td>
</tr>    

<form:errors path="email" cssClass="error"/>

<tr>
    <td align="right">Email id :</td>
    <td>
        <form:input placeHolder="Enter the Email ID" path="email" htmlEscape="true" autocomplete="false"/>
    </td>
</tr>  

<form:errors path="phone" cssClass="error"/>

<tr>
    <td align="right">Mobile :</td>
    <td>
        <form:input placeHolder="Enter the Mobile Number" path="phone" htmlEscape="true" autocomplete="false" />
    </td>
</tr>

<form:errors path="team" cssClass="error"/>
    
<tr>
    <td align="right">Team :</td>
    <td><form:select path="team" class="login login-submit">
            <form:option class="login login-submit" value="">Select</form:option>
	    <c:forEach  items="${AllTeams}" var="team"> 
	    <form:option class="login login-submit" value="${team.teamname}">${team.teamname}</form:option>
	    </c:forEach>
        </form:select>
    </td>
</tr>
      
<form:errors path="role" cssClass="error"/>
<tr><td align="right">User Role :</td>
    <td><form:select class="login login-submit" path="role">
        <form:option class="login login-submit" value="">Select</form:option>
	<form:option class="login login-submit" value="Admin">Admin</form:option>
	<form:option class="login login-submit" value="Manager">Delivery Manager</form:option>
        <form:option class="login login-submit" value="Manager">Project Manager</form:option>
        <form:option class="login login-submit" value="Lead">Delivery Lead</form:option>
        <form:option class="login login-submit" value="Engineer">Engineer</form:option>   
        <form:option class="login login-submit" value="Scheduling">Scheduling</form:option>
    </form:select>
    </td>
</tr>

<input type="hidden" name="AntiCSRFToken" value="${csrfPreventionSalt}"/> 

<tr>
    <td></td>
    <td align="left"><input type="submit" value="Create" class="login login-submit"/></td>
</tr>

</table>

</form:form>
     
<center>${Lerror}</center>      

</body>

</html>
