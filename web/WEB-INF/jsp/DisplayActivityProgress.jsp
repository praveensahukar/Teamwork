<%-- 
    Document   : DisplayProjectProgress
    Created on : 14 May, 2017, 9:07:43 PM
    Author     : root
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}
.login-card input[type=text], input[type=password] {
  height: 30px;
  font-size: 16px;
  width: 50%;
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
  width: 150px;
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
	width: 99%; /*set table width here if using fixed value*/
	/*min-width: 100%;*/ /*set table width here if using %*/
	min-height: 550px; /*set table height here; can be fixed value or %*/
	/*min-height: 104px;*/ /*if using % height, make this at least large enough to fit scrollbar arrows + captions + thead*/
	font-family: Verdana, Tahoma, sans-serif;
	font-size: 15px;
	line-height: 20px;
	padding-top: 10px; /*this determines top caption height*/
	padding-bottom: 20px; /*this determines bottom caption height*/
	text-align: left;
}
.scrollingtable * {box-sizing: border-box;}
.scrollingtable > div {
	position: relative;
	border-top: 4px solid black; /*top table border*/
        border-bottom: 0px solid black;
        border-left: 0px solid black;
	height: 100%;
	padding-top: 20px; /*this determines column header height*/
}
.scrollingtable > div:before {
	top: 20px;
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
	max-height: 550px;
	overflow: scroll; /*set to auto if using fixed or % width; else scroll*/
	overflow-x: hidden;
	border: 3px solid black; /*border around table body*/
        margin-top: 20px;
}
.scrollingtable > div > div:after {background: white;} /*match page background color*/
.scrollingtable > div > div > table {
	width: 100%;
	border-spacing: 1px;
	margin-top: -45px; /*inverse of column header height*/
	/*margin-right: 17px;*/ /*uncomment if using % width*/
}
.scrollingtable > div > div > table > caption {
	position: absolute;
	top: 20px; /*inverse of caption height*/
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

/*Table header */
.scrollingtable > div > div > table > thead > tr > * > div {
	display: inline-block;
	padding: 10px 10px 10px 10px; /*header cell padding*/
}
.scrollingtable > div > div > table > thead > tr > :first-child:before {
	content: "";
	position: absolute;
	top: 0;
	left: 0;
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
	min-height: 20px; /*match column header height*/
	padding-top: 1px;
	border-left: 1px solid black; /*borders between header cells*/
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
	border-top: 6px solid black;
	top: -1px; /*inverse of border width*/
}
.scrollingtable > div > div > table > tbody {vertical-align: top;}
.scrollingtable > div > div > table > tbody > tr {background: white;}
.scrollingtable > div > div > table > tbody > tr > * {
	border-bottom: 2px solid black;
	padding: 4px 4px 4px 4px;
	height: 20px; /*match column header height*/
}
.scrollingtable > div > div > table > tbody:last-of-type > tr:last-child > * {border-bottom: none;}
.scrollingtable > div > div > table > tbody > tr:nth-child(even) {background: gainsboro;} /*alternate row color*/
.scrollingtable > div > div > table > tbody > tr > * + * {border-left: 1px solid black;}

.dropdown3 {
    float: left;
    overflow: auto;
}

.dropdown3 .dropbtn3 {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: white;
}

.dropdown3 .dropbtn13 {
    font-size: 16px;    
    border: none;
    outline: none;
    height: 40px;
    width: 200px;
    color: #111;
    padding: 10px 10px;
    background-color: #b9b9b9;
    text-align: left;
}

.container a:hover, .dropdown3:hover .dropbtn3 {
    background-color: #cc0000;
}

.dropdown-content3 {
    display: none;
    position: absolute;
    background-color: #999966;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content3 a {
    float: none;
    color: black;
    padding: 10px 12px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content3 a:hover {
    background-color: #ddd;
}

.dropdown3:hover .dropdown-content3 {
    display: block;
}




</style>



<title>Activity Progress</title>

</head>
    <body>
    
  <%@include file="Header.jsp" %>
   
    <div class="login-card" >
        <div align="center">  <h3 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Activity Details</h3></div>
	<div class="right">
            
            
    <table border="1" >
        <thead>
            <tr>
                <td colspan="2"><h4 style="color: grey; font-size: 15px"><g style="color:black">Activity Name:</g> ${fn:escapeXml(ProjectData.activityname)}</h2></td>
            </tr>
        </thead>
        
            <tr>
            <td><h4 style="color: grey; font-size: 15px"><g style="color:black">OPID:</g> ${fn:escapeXml(ProjectData.opid)}</h4></h3></td>
            <td><h4 style="color: grey; font-size: 15px"><g style="color:black">Team:</g> ${fn:escapeXml(ProjectData.team)}</h4></td>
            </tr>
        
            <tr>
            <td><h4 style="color: grey; font-size: 15px"><g style="color:black">Lead Assigned:</g> ${fn:escapeXml(ProjectData.lead)}</h4></td>
            <td><h4 style="color: grey; font-size: 15px"><g style="color:black">Test Engineer: </g> ${fn:escapeXml(Engineer)}</h4></td>
            </tr>
        
            <tr>
            
            <td> <h4 style="color: grey; font-size: 15px" ><g style="color:black">Start Date:</g>
                   <fmt:formatDate type = "date" value = "${ProjectData.startdate}"/></h4></td>
            <td> <h4 style="color: grey; font-size: 15px" ><g style="color:black">End Date: </g>
                    <fmt:formatDate type = "date" value = "${ProjectData.enddate}"/></h4></td>
            
           </tr>
           
           <tr>
               <td>
                <h4 style="color: grey; font-size: 15px"><g style="color:black">Status:</g>
                    </td>
                    <td>
               <div class="dropdown3">
                    <button class="dropbtn13">${fn:escapeXml(ProjectData.status)}</button>
                     <div class="dropdown-content3">
                        <a href="updateProjectStatus.do?pid=${ProjectData.activityid}&status=New">New</a>
                        <a href="updateProjectStatus.do?pid=${ProjectData.activityid}&status=Progress">Progress</a>
                        <a href="updateProjectStatus.do?pid=${ProjectData.activityid}&status=Completed">Completed</a> 
                      </div>
                    </div> 
                    </td>
           </tr>
        </table>
        <br>
	</div>

       <div class="scrollingtable">
		<div>
			<div>
                                                        
<fmt:formatDate value="${ProjectTaskList.enddate}" var="AEDate" type="both" dateStyle = "short" timeStyle = "short" />
    <table border="1">
        <thead>
            <tr >
        <th><div label="Task Name"></div> </th>
       <%-- <th><div label="Engineer Name"> </div></th> --%>
        <th><div label="Scheduled Start Date"> </div></th>
        <th><div label="Scheduled End Date"> </div></th>
        <th><div label="Hours"> </div></th>
        <th><div label="Days"> </div></th>
        <th><div label="Status"> </div></th>
        <th><div label="Actual Start Date"> </div></th>
        <th><div label="Actual End Date"> </div></th>
        
        </thead>
         <tbody>
    <c:forEach  items="${TaskDetails}" var="ProjectTaskList">  
        
        <fmt:formatDate value="${ProjectTaskList.taskstartdate}" var="SDate" type="both" dateStyle = "short" timeStyle = "short"/>
        
        <fmt:formatDate value="${ProjectTaskList.taskenddate}" var="EDate" type="both" dateStyle = "short" timeStyle = "short" />
        
        <fmt:formatDate value="${ProjectTaskList.startdate}" var="ASDate" type="both" dateStyle = "short" timeStyle = "short"/>
        <fmt:formatDate value="${ProjectTaskList.enddate}" var="AEDate" type="both" dateStyle = "short" timeStyle = "short" />
        
        <tr> 
            <td style="color: black">${fn:escapeXml(ProjectTaskList.taskname)}</td>
            <%-- <td style="color: black">${fn:escapeXml(ProjectTaskList.engname)}</td> --%>
            <td style="color: black">${fn:escapeXml(SDate)}</td>
	        <td style="color: black">${fn:escapeXml(EDate)}</td>
            <td style="color: black">${fn:escapeXml(ProjectTaskList.taskhours)}</td>
            <td style="color: black">${fn:escapeXml(ProjectTaskList.taskdays)}</td>
           
            <td style="color: black">
            <div class="dropdown">
            <button class="dropbtn1">${fn:escapeXml(ProjectTaskList.status)}</button>
                <div class="dropdown-content">
                <a href="updateTaskStatus.do?pid=${ProjectTaskList.activityid}&tid=${ProjectTaskList.transid}&status=Progress">Progress</a>
                <a href="updateTaskStatus.do?pid=${ProjectTaskList.activityid}&tid=${ProjectTaskList.transid}&status=Completed">Completed</a> 
                <a href="updateTaskStatus.do?pid=${ProjectTaskList.activityid}&tid=${ProjectTaskList.transid}&status=Hold">On Hold</a>
                </div>
        </div> 
        </td> 

         
        <c:set var = "DDate" value = "1/1/90 12:00 AM"/>
              
        <td style="color: black">   ${(ASDate eq DDate)? "--/--/--" : ASDate}</td>
       
        <td style="color: black">  ${(AEDate eq DDate)? "--/--/--" : AEDate}</td>
       
        </tr>
         
       </c:forEach>
      
         </tbody>
</table>
       

        </div>
        <br>
        <a href="/TeamWorkAlpha/uploadfiles.do?pid=${ProjectData.activityid}" 
  target="popup" 
  onclick="window.open('/TeamWorkAlpha/uploadfiles.do?pid=${ProjectData.activityid}','popup','width=800,height=600'); return false;">
    Upload files
</a>
    <br>
    <br>
<a href="/TeamWorkAlpha/Downloadfiles.do?pid=${ProjectData.activityid}" 
  target="popup" 
  onclick="window.open('/TeamWorkAlpha/Downloadfiles.do?pid=${ProjectData.activityid}','popup','width=800,height=600'); return false;">
    Download files
</a>
    <br>  
    <br>
    <a href="addActivityTask.do?activityId=${ProjectData.activityid}"><button>Add Task</button></a> <br>
    
    <br>  <a href="deleteProject.do?pid=${ProjectData.activityid}"><button onclick="return confirm('Are you sure you want to delete this activity?')">Delete Activity</button></a>

<br>

</body>

</html>