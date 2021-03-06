<%-- 
    Document   : DisplayProjectStatus
    Created on : May 10, 2017, 6:51:12 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel="icon" href="Network-Security.png" type="image/x-icon">
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
  min-height: 550px;
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
  width: 300px;
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

.login-submit:hover {
  /* border: 1px solid #2f5bb7; */
  border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #ff8080;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
}

.login-submit {
  /* border: 1px solid #3079ed; */
  width: 200px;
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #a6a6a6;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
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
}

.scrollingtable {
	box-sizing: border-box;
	display: inline-block;
	vertical-align: middle;
	overflow: hidden;
	width: 60%; /*set table width here if using fixed value*/
	/*min-width: 100%;*/ /*set table width here if using %*/
	height: 60%; /*set table height here; can be fixed value or %*/
	/*min-height: 104px;*/ /*if using % height, make this at least large enough to fit scrollbar arrows + captions + thead*/
	font-family: Verdana, Tahoma, sans-serif;
	font-size: 15px;
	line-height: 30px;
	padding-top: 20px; /*this determines top caption height*/
	padding-bottom: 20px; /*this determines bottom caption height*/
	text-align: left;
}
.scrollingtable * {box-sizing: border-box;}
.scrollingtable > div {
	position: relative;
	
        border-top: 4px solid black;
        border-bottom: 4px solid black;
	height: 100%;
	padding-top: 10px; /*this determines column header height*/
        padding-bottom: 0px;
}
.scrollingtable > div:before {
	top: 0;
	background: cornflowerblue; /*column header background color*/
}
.scrollingtable > div:before,
.scrollingtable > div > div:after {
	content: "";
	position: absolute;
	z-index: -1;
	width: 100%;
	height: 50%;
	left: 0;
}
.scrollingtable > div > div {
	/*min-height: 43px;*/ /*if using % height, make this at least large enough to fit scrollbar arrows*/
	max-height: 100%;
	overflow: scroll; /*set to auto if using fixed or % width; else scroll*/
	overflow-x: hidden;
	border: 0px solid black; /*border around table body*/
}
.scrollingtable > div > div:after {background: white;} /*match page background color*/
.scrollingtable > div > div > table {
	width: 99.9%;
	margin-top: -100px; /*inverse of column header height*/
	/*margin-right: 17px;*/ /*uncomment if using % width*/
}
.scrollingtable > div > div > table > caption {
	position: absolute;
        height: 40px;
	top: 20px; /*inverse of caption height*/
	margin-top: -1px; /*inverse of border-width*/
	width: 100%;
	font-weight: bold;
	text-align: left;
}
.scrollingtable > div > div > table > * > tr > * {padding: 0px;}
.scrollingtable > div > div > table > thead {
	vertical-align: bottom;
	white-space: nowrap;
	text-align: center;
        
}
.scrollingtable > div > div > table > thead > tr > * > div {
	display: inline-block;
	padding: 40px 60px 40px 60px; /*header cell padding*/
       
}
.scrollingtable > div > div > table > thead > tr > :first-child:before {
	content: "";
	position: absolute;
	top: 0;
	left: 0;
	height: 0px; /*match column header height*/
	border-left: 4px solid black; /*leftmost header border*/
}
.scrollingtable > div > div > table > thead > tr > * > div[label]:before,
.scrollingtable > div > div > table > thead > tr > * > div > div:first-child,
.scrollingtable > div > div > table > thead > tr > * + :before {
	position: absolute;
	top: 0;
	white-space: pre-wrap;
	color: black; /*header row font color*/
     
}
.scrollingtable > div > div > table > thead > tr > * > div[label]:before,
.scrollingtable > div > div > table > thead > tr > * > div[label]:after {content: attr(label);}
.scrollingtable > div > div > table > thead > tr > * + :before {
	content: "";
	display: block;
	min-height: 40px; /*match column header height*/
	padding-top: 10px;
	border-left: 0px solid black; /*borders between header cells*/
}
.scrollingtable .scrollbarhead {float: right;}
.scrollingtable .scrollbarhead:before {
	position: absolute;
	width: 100px;
	top: -1px; /*inverse border-width*/
	background: white; /*match page background color*/
}
.scrollingtable > div > div > table > tbody > tr:after {
	content: "";
	display: table-cell;
	position: relative;
	padding: 0;
	border-top: 0px solid black;
	top: -1px; /*inverse of border width*/
}
.scrollingtable > div > div > table > tbody {vertical-align: top;}
.scrollingtable > div > div > table > tbody > tr {background: white;}
.scrollingtable > div > div > table > tbody > tr > * {
	border: 0px solid black;
	padding: 15px 6px 15px 6px;
	height: 30px; /*match column header height*/
}
.scrollingtable > div > div > table > tbody:last-of-type > tr:last-child > * {border-bottom: 0px solid black;}
.scrollingtable > div > div > table > tbody > tr:nth-child(even) {background: gainsboro;} /*alternate row color*/
.scrollingtable > div > div > table > tbody > tr > * + * {border-left: 3px solid black; padding: 4px; border-right:3px solid black;}




</style>

<title>All Companies</title>
</head>
<body>
    <%@include file="Header.jsp" %>        
    <div class="login-card">
    <div align="left"> 
        <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">All Companies</h2>
    </div>
    
    
        
    <div class="scrollingtable" style= "display: inline-block; float: left; margin-right: 30px;">
    <div>
    <div>
  
    <table boder="0">
    
    <tbody>
            
        <c:forEach  items="${AllCompany}" var="company">     
           <tr>
               <td><a href="${company.website}"> ${fn:escapeXml(company.companyname)}</a>
                    <a href="DeleteCompany.do?id=${company.companyid}" style="float:right;">
                    <img  src="delete.png" alt="Delete User" style="width:18px;height:18px;border:0; margin-right:30px;" 
                          onclick="return confirm('Are you sure you want to delete this Company?')">
                    </a>
                </td>
               
        
           </tr> 
        </c:forEach>
                
    </tbody>
    </table>
    </div>
    </div>
    </div>
        
        
        
    </div>
    </body>
</html>
