<%-- 
    Document   : DisplayProjectProgress
    Created on : 14 May, 2017, 9:07:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"></script>
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
  height: 650px;
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

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #F7F7F7}

th {
    background-color: #a6a6a6;
    color: white;
}

</style>

<script>
$(document).ready(function() {
    $('#example').DataTable( {
        "scrollY":"300px",
        "scrollCollapse": true,
        "paging":         false,
        "sorting": false,
        
    } );
} );
</script>

<title>Project Progress</title>

</head>
    <body>
    
  <%@include file="Header.jsp" %>
        
    <div class="login-card" >
        <div align="center">  <h3 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Project Details</h3></div>
	<div class="right">
            
            
    <table border="1"  class="display" width="100%"  cellspacing="0">
        <thead>
            <tr bgcolor="#a6a6a6">
            <td ><h4 style="color: white; font-size: 15px">Project Name: ${ProjectData.projectname}</h2></td>
            <td ><h4 style="color: white; font-size: 15px">OPID: ${ProjectData.opid}</h4></h3></td>
            </tr>
        </thead>
	   
	<tr>
            <td><h4 style="color: red; font-size: 15px">Lead Assigned: ${ProjectData.lead}</h4></td>
            <td><h4 style="color: red; font-size: 15px">Project Status: ${ProjectData.status}</h4></td>
        </tr>
        
        <tr>
            
            <td> <h4 style="color: red; font-size: 15px" >Start Date:
                   <fmt:formatDate type = "date" value = "${ProjectData.startdate}"/></h4></td>
            <td> <h4 style="color: red; font-size: 15px" >End Date: 
                   <fmt:formatDate type = "date"  value = "${ProjectData.enddate}"/></h4></td>
        </tr>
        </table>
        <br>
	</div>


        
             
        
          
    <table border="1" id="example" class="display" width="100%"  cellspacing="0">
        <thead>
            <tr bgcolor="#a6a6a6">
        <th style="color: white">Task Name </th>
        <th style="color: white">Engineer Name </th>
        <th style="color: white">Task Start Date</th>
        <th style="color: white">Start End Date</th>
        <th style="color: white">Hours</th>
        <th style="color: white">Days</th>
        <th style="color: white">Status</th>
        <th style="color: white">Delay</th>
        </thead>
         <tbody>
    <c:forEach  items="${TaskDetails}" var="ProjectTaskList">  
        
        <fmt:formatDate value="${ProjectTaskList.taskstartdate}" var="SDate" type="both" dateStyle = "short" timeStyle = "short"/>
        <fmt:formatDate value="${ProjectTaskList.taskenddate}" var="EDate" type="both" dateStyle = "short" timeStyle = "short" />
        
        <tr> 
            <td style="color: black">${ProjectTaskList.taskname}</td>
            <td style="color: black">${ProjectTaskList.engname}</td>
            <td style="color: black">${SDate}</td>
	        <td style="color: black">${EDate}</td>
            <td style="color: black">${ProjectTaskList.taskhours}</td>
            <td style="color: black">${ProjectTaskList.taskdays}</td>
           
            <td style="color: black">
            <div class="dropdown">
            <button class="dropbtn1">${ProjectTaskList.status}</button>
                <div class="dropdown-content">
                <a href="updateTaskStatus.do?pid=${ProjectTaskList.projectid}&tid=${ProjectTaskList.transid}&status=New">New</a>
                <a href="updateTaskStatus.do?pid=${ProjectTaskList.projectid}&tid=${ProjectTaskList.transid}&status=Progress">Progress</a>
                <a href="updateTaskStatus.do?pid=${ProjectTaskList.projectid}&tid=${ProjectTaskList.transid}&status=Completed">Completed</a> 
                </div>
        </div> 
        </td> 
        <%--Individual task delay form --%>
         <td style="color: black">
             <table>
                 <tr>
                     <td>
            <form action="updateTaskDelay.do" method="post">
                <td>  <input type="text" placeholder="Delay Hours" name="taskDelayTime"/></td>
               <input type="hidden" name="transId" value="${ProjectTaskList.transid}"/>
               <input type="hidden" name="projectid" value="${ProjectData.projectid}"/>
               <input type="hidden" name="AntiCSRFToken" value="${csrfPreventionSalt}"/> 
               <td> <input type="submit" value="Update Delay"/></td>
            
            </form>
                     </td>
                 </tr>
             </table>
            </td>
            
        </tr>
         
      
       </c:forEach>
         </tbody>
</table>
       
         
<a href='#' onclick='javascript:window.open("http://localhost:8888/TeamWork/uploadfiles.do?pid=${ProjectData.projectid}", "_blank", "scrollbars=1,resizable=1,height=600,width=950");' title='Pop Up'>Document Upload</a>
<br>
<a href='#' onclick='javascript:window.open("http://localhost:8888/TeamWork/Downloadfiles.do?pid=${ProjectData.projectid}", "_blank", "scrollbars=1,resizable=1,height=600,width=950");' title='Pop Up'>Document download</a> 
</div>

    </body>

</html>
