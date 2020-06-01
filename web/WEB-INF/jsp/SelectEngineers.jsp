<%-- 
    Document   : CreateProject
    Created on : 24 Apr, 2017, 5:28:38 PM
    Author     : Administrator
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<head>
<script type="text/javascript">
  $(document).ready(function() {
    $("#date").datepicker();
    format: 'dd/mm/yyyy'
  });
  </script>
  <script type="text/javascript">
  $(document).ready(function() {
    $("#datepicker").datepicker();
    format: 'dd/mm/yyyy'
  });
  </script>
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
  width: 20%;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}
.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 30%;
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
  width: 50%;
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #a6a6a6;
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
    width: 60%;
    color: #ff0000;
    border-color: white;
    align-items: center;
}
th {
    text-align: left;
}
.error {
color: red;
font-style: italic;
}
</style>
    
<title>Assign Engineers</title>
</head>
    
<body>

<%@include file="Header.jsp"%>
	   <div class="login-card">
               <center><h4 style="color: #ffffff"><b>${Message}</b></h4></center>
	   <div align="left">  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Assign/Block Resource</h2></div>
<form:form action="ScheduleActivity.do" method="post" commandName="ProjectM">
<div align="left">
    <input type="hidden" name="AntiCSRFToken" id="token" value="${csrfPreventionSalt}"/>
    <input type="hidden" name="scheReqID" value="${scheReqID}"/>
    <table  align="left" border="0">

<tr><td align="right"><h4>Activity : ${fn:escapeXml(activitybean.activityname)}</td> </tr>

<tr><td align="right"><h4>Available Engineers :</td>
    <td><form:select path="engtracker" id="engineer" class="login login-submit">
        <option class="login login-submit" value="">Select Engineer</option>
	    <c:forEach  items="${engineers}" var="eng"> 
	    <form:option class="login login-submit" value="${eng.userid}">${eng.username}  :  ${eng.team} </form:option>
	    </c:forEach>
        </form:select>
        <form:errors path="engtracker" cssClass="error"/>
    </td>
</tr>

<tr><td align="right"><h4>Template :</td>
    <td><form:select  path="templateid" itemLabel="Select" class="login login-submit"> 
         <option class="login login-submit" value="">Select Template</option>
	  <c:forEach items="${AllTemplates}" var="template">     
	  <option class="login login-submit" value="${template.templateid}">${template.templatename}</option>
	  </c:forEach>
          <form:errors path="templateid" cssClass="error"/>	  
        </form:select>
     </td>
</tr>


<tr><td align="right"><h4>Start Date :<td><form:input placeholder="Enter Start Date" id="date" path="startdate" /><form:errors path="startdate" cssClass="error"/></h4></td></tr>
<tr><td align="right"><h4>End Date :</td><td><form:input placeholder="Enter End Date" id="datepicker" path="enddate"/><form:errors path="enddate" cssClass="error"/></h4></td></tr>


<tr><td align="right"><input type="submit" value="Submit" class="login login-submit"/></td></tr>           
</table >
</div>
</form:form>
      
</div>
     
	   <script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
    format: 'dd/mm/yyyy';
  });
  </script>
  <script>
  $(document).ready(function() {
    $("#datepickers").datepicker();
    format: 'dd/mm/yyyy';
  });
  </script>
    </body>
</html>