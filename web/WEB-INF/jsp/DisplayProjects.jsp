<%-- 
    Document   : DisplayProjectStatus
    Created on : May 10, 2017, 6:51:12 AM
    Author     : user
--%>

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

<!--<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" href="jquery.dataTables.min.css">-->
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
  width: 10%;
  display: block;
  height: 20px;
  margin-bottom: 10px;
  position: relative;
  float: center;
}

.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 20%;
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
  top: 10px;
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



html {
	/*width: 100%;*/ /*required if using % width*/
	/*height: 100%;*/ /*required if using % height*/
}

.scrollingtable {
	box-sizing: border-box;
	display: inline-block;
	vertical-align: middle;
	overflow: hidden;
	width: 100%; /*set table width here if using fixed value*/
	/*min-width: 100%;*/ /*set table width here if using %*/
	height: 80%; /*set table height here; can be fixed value or %*/
	/*min-height: 104px;*/ /*if using % height, make this at least large enough to fit scrollbar arrows + captions + thead*/
	font-family: Verdana, Tahoma, sans-serif;
	font-size: 15px;
	line-height: 20px;
	padding-top: 20px; /*this determines top caption height*/
	padding-bottom: 20px; /*this determines bottom caption height*/
	text-align: left;
}
.scrollingtable * {box-sizing: border-box;}
.scrollingtable > div {
	position: relative;
	border-top: 1px solid black; /*top table border*/
	height: 100%;
	padding-top: 20px; /*this determines column header height*/
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
	border: 1px solid black; /*border around table body*/
}
.scrollingtable > div > div:after {background: white;} /*match page background color*/
.scrollingtable > div > div > table {
	width: 100%;
	border-spacing: 0;
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
	border-top: 1px solid black;
	top: -1px; /*inverse of border width*/
}
.scrollingtable > div > div > table > tbody {vertical-align: top;}
.scrollingtable > div > div > table > tbody > tr {background: white;}
.scrollingtable > div > div > table > tbody > tr > * {
	border-bottom: 1px solid black;
	padding: 0 6px 0 6px;
	height: 20px; /*match column header height*/
}
.scrollingtable > div > div > table > tbody:last-of-type > tr:last-child > * {border-bottom: none;}
.scrollingtable > div > div > table > tbody > tr:nth-child(even) {background: gainsboro;} /*alternate row color*/
.scrollingtable > div > div > table > tbody > tr > * + * {border-left: 1px solid black;} /*borders between body cells*/
</style>
<script>
/* THIS JAVASCRIPT JUST ADDS ROWS FOR TESTING PURPOSES */
(function() {
  for(var n=8, r=document.querySelector("tbody>tr"), p=r.parentNode; n--; p.appendChild(r.cloneNode(true)));
})();
</script>
<script>
        function fnExcelReport()
{
    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
    var textRange; var j=0;
    tab = document.getElementById('team'); // id of table

    for(j = 0 ; j < tab.rows.length ; j++) 
    {     
        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
        //tab_text=tab_text+"</tr>";
    }

    tab_text=tab_text+"</table>";
    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE "); 

    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
    {
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write(tab_text);
        txtArea1.document.close();
        txtArea1.focus(); 
        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
    }  
    else                 //other browser not tested on IE 11
        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

    return (sa);
}
        </script>
<title>All Projects</title>
</head>
    <body>
         

<%@include file="Header.jsp" %>
         

        <div class="login-card">
	   <div align="left">  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">All Projects</h2><br></div>
           <div align="right" style="top: 10px"> <button  class="login login-submit" id="btnExport" onclick="fnExcelReport();"> EXPORT TO EXCEL </button></div>
     
           <div class="scrollingtable">
		<div>
			<div>
           
           <table id="team">
        <thead>
            <tr >
                
                <th><div label="OPID"></div> OPID</th>
                <th><div label="Project Title"></div>Project Title</th>
                <th><div label="Lead"></div>Lead</th>
                <th><div label="Start Date"></div>Start Date</th>
                <th><div label="End Date"></div>End Date</th>
                <th><div label="Man Days"></div>Status</th>
                <th><div label="Status"></div>Status</th>
                <th><div label="Delete"></div>Delete Project</th>
           
            </tr>
        </thead>
            
            <tbody>
            
<c:forEach items="${AllProjects}" var="project">     
    
<fmt:formatDate value="${project.startdate}" var="SDate" type="date" pattern="dd-MMM-yyyy" />
<fmt:formatDate value="${project.enddate}" var="EDate" type="date" pattern="dd-MMM-yyyy" />
	   
            <tr> 
                
                <td > <a href="showProgress.do?id=${project.projectid}"> ${fn:escapeXml(project.opid)}</a></td>
	        <td >${fn:escapeXml(project.projectname)}</td>
                <td >${fn:escapeXml(project.lead)}</td>
                <td >${fn:escapeXml(SDate)}</td>
                <td >${fn:escapeXml(EDate)}</td>
                <td >${fn:escapeXml(project.mandays)}</td>
                <td >
                    <div class="dropdown">
                    <button class="dropbtn1">${fn:escapeXml(project.status)}</button>
                      <div class="dropdown-content">
                        <a href="updateProjectStatus.do?pid=${project.projectid}&status=New">New</a>
                        <a href="updateProjectStatus.do?pid=${project.projectid}&status=Progress">Progress</a>
                        <a href="updateProjectStatus.do?pid=${project.projectid}&status=Completed">Completed</a> 
                      </div>
                    </div> 
                </td>
                <td >  <div class="dropdown"><a href="deleteProject.do?pid=${project.projectid}"><button class="dropbtn1">Delete</button></a> </div></td>
	   </tr>
           
</c:forEach>
            </tbody>
          
        </table>
     
 </div>
           
	   </div>
      
     
         <iframe id="txtArea1" style="display:none"></iframe>
     
</body>
</html>
