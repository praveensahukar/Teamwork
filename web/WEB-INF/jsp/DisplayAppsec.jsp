<%-- 
    Document   : DisplayAppsec
    Created on : Apr 15, 2020, 6:22:23 PM
    Author     : pal
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
  width: 10%;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}

.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: auto;
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
  width: 20%;
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


.scrollingtable {
	box-sizing: border-box;
	display: inline-block;
	vertical-align: middle;
	overflow: hidden;
	width: 95%; /*set table width here if using fixed value*/
	/*min-width: 100%;*/ /*set table width here if using %*/
	height: 60%; /*set table height here; can be fixed value or %*/
	/*min-height: 104px;*/ /*if using % height, make this at least large enough to fit scrollbar arrows + captions + thead*/
	font-family: Verdana, Tahoma, sans-serif;
	font-size: 20px;
	line-height: 20px;
	padding-top: 20px; /*this determines top caption height*/
	padding-bottom: 20px; /*this determines bottom caption height*/
	text-align: left;
}
.scrollingtable * {box-sizing: border-box;}
.scrollingtable > div {
	position: relative;
	border-top: 5px solid black; /*top table border*/
	height: 100%;
	padding-top: 30px; /*this determines column header height*/
}
.scrollingtable > div:before {
	top: 0px;
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
	border: 3px solid black; /*border around table body*/
}
.scrollingtable > div > div:after {background: white;} /*match page background color*/
.scrollingtable > div > div > table {
	width: 99.5%;
	border-spacing: 2px;
	margin-top: -20px; /*inverse of column header height*/
	/*margin-right: 17px;*/ /*uncomment if using % width*/
}
.scrollingtable > div > div > table > caption {
	position: absolute;
	top: -20px; /*inverse of caption height*/
	margin-top: -1px; /*inverse of border-width*/
	width: 100%;
	font-weight: bold;
	text-align: center;
}
.scrollingtable > div > div > table > * > tr > * {padding: 0;}
.scrollingtable > div > div > table > thead {
	vertical-align: bottom;
	white-space: nowrap;
	text-align: center;
}
.scrollingtable > div > div > table > thead > tr > * > div {
	display: inline-block;
	padding: 0 6px 0 6px; /*header cell padding*/
}
.scrollingtable > div > div > table > thead > tr > :first-child:before {
	content: "";
	position: absolute;
	top: 1px;
	left: 1px;
	height: 20px; /*match column header height*/
	border-left: 1px solid black; /*leftmost header border*/
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
	min-height: 30px; /*match column header height*/
	padding-top: 3px;
	border-left: 2px solid black; /*borders between header cells*/
        border-right: 2px solid black;
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
	border-top: 1px solid black;
	top: -1px; /*inverse of border width*/
}
.scrollingtable > div > div > table > tbody {vertical-align: top;}
.scrollingtable > div > div > table > tbody > tr {background: white;}
.scrollingtable > div > div > table > tbody > tr > * {
	border-bottom: 2px solid black;
	padding: 10px;
	height: 50px; /*match column header height*/
}
.scrollingtable > div > div > table > tbody:last-of-type > tr:last-child > * {border-bottom: 1px solid black;}
.scrollingtable > div > div > table > tbody > tr:nth-child(even) {background: gainsboro;} /*alternate row color*/
.scrollingtable > div > div > table > tbody > tr > * + * {border-left: 2px solid black; boder-right: 2px solid black}


</style>



<title>All AppSecActivity</title>
</head>
    
<body>
    <%@include file="Header.jsp" %>        
    <div class="login-card">
    <div align="left">  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Application Security Schedule Requests</h2><br></div>
    <div class="scrollingtable">
		<div>
			<div>
    <table>
        <thead>
            <tr bgcolor="#a6a6a6">
                <th><div label="Project Name"></div> </th>
                <th><div label="Assesment Type"></div> </th>
                <th><div label="Application Name"></div> </th>
                <th><div label="Prefered Start Date"></div> </th>
            <th><div label="Hosting"></div> </th>
            <th><div label="Scope"></div> </th>
            <th><div label="Status"></div> </th>
            
          
          
           <%-- <th><div label="Delete"></div> </th> --%>
        </tr>
        </thead>
    
    
    <tbody>
            
        <c:forEach  items="${AllAppsec}" var="appsec">     
           <tr>
               <td>${fn:escapeXml(appsec.projectname)}</td>
               <td> 
                   ${fn:escapeXml(appsec.assesstype)}
                   <a href="EditAppSecDetails.do?asid=${appsec.as_scheduleid}" style="float:right;">
                        <img src="icons8-edit.png" alt="Edit codereview" style="width:18px;height:18px;border:0;">
                   </a>
                   <a href="DeleteAppRequest.do?id=${appsec.as_scheduleid}" style="float:right; margin-right: 20px;">
                        <img  src="delete.png" alt="Delete schedule" style="width:18px;height:18px;border:0;" 
                              onclick="return confirm('Are you sure you want to delete the request-schedule?')">
                    </a>
               </td>
               <td> <a href="GetScheduleAllocationAppSec.do?asid=${appsec.as_scheduleid}">${fn:escapeXml(appsec.appname)}</a></td>
               <td> ${fn:escapeXml(appsec.prefstartdate)}</td>
               <td> ${fn:escapeXml(appsec.hosting)}</td>
               <td> ${fn:escapeXml(appsec.scope)}</td>
               <td style="color: red;"> ${fn:escapeXml(appsec.status)}</td>
               
          
              <%-- <td><a href="DeleteProject.do?id=${project.projectid}">DELETE</a></td> --%>
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

