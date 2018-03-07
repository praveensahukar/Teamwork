

<%-- 
    Document   : CreateProject
    Created on : 24 Apr, 2017, 5:28:38 PM
    Author     : Administrator
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
    <script type="text/javascript">
  $(document).ready(function() {

    $("#date").datepicker({
        showOn: 'button',
        buttonText: 'Show Date',
        buttonImageOnly: true,
        buttonImage: 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
    });
});
  </script>  
  
  <script type="text/javascript">
  $(document).ready(function() {

    $("#datepicker").datepicker({
        showOn: 'button',
        buttonText: 'Show Date',
        buttonImageOnly: true,
        buttonImage: 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
    });
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
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}
.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 150%;
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
    width: 95%;
    color: black;
    border-color: black;
    align-items: center;
}
th {
    text-align: left;
}
.error {
color: black;
font-style: italic;
}

#sumukh {
  
    column-gap: 40px;
  width: 1420px;
  height: 100px;
}

#sumukh > div {
  width: 70px;
  height: 100px;
  
}
#sumukha {
  display: flex;
  justify-content: space-around;
  
  width: 1420px;
  height: 100px;
}

#sumukha > div {
  width: 70px;
  height: 100px;
  
}
.sumukh-submit {
  /* border: 1px solid #3079ed; */
  border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #ff8080;
  text-align: center;
  font-size: 14px;
  font-family: 'Arial', sans-serif;
  font-weight: 700;
  height: 36px;
  padding: 0 8px;
  width: 100%;
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #a6a6a6;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

#overflowTest {
    padding: 15px;
    height: 100px;
    overflow: scroll;
    border: 1px solid #ccc;
}

.santosh
{
    display: inline-flex;
    width: 200px;
}

</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".sumukh-submit").click(function(){
            var engineer      =    $("#engineer").val();
            var date          =    $("#date").val();
            var datepicker    =    $("#datepicker").val();
            
            var markup = "<tr> <td>"+ engineer +"</td> <td>" + date + "</td> <td>" + datepicker + "</td></tr>";
            $("table tbody").append(markup);
        });
        
        // Find and remove selected table rows
        $(".delete-row").click(function(){
            $("table tbody").find('input[name="record"]').each(function(){
            	if($(this).is(":checked")){
                    $(this).parents("tr").remove();
                }
            });
        });
    });    
</script>
  <title>Assign Engineers</title>
    </head>
    <body>

<%@include file="Header.jsp"%>
	   <div class="login-card">
	   <div align="left">  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Assign/Block Resource</h2></div>
<form:form action="ScheduleActivity.do" method="post" commandName="ProjectM">
<div align="left">
    <input type="hidden" name="AntiCSRFToken" id="token" value="${csrfPreventionSalt}"/>
    
    
        
            
            
<!-- addrow-->
<!-- addrow-->

<!-- addrow-->
<!-- addrow-->

 <div id="sumukh"> 

    
        <div class="col1">
            <h4>Template</h4><form:select style="width:130px"  path="templateid" itemLabel="Select">
         <option class="login login-submit" value="">Select Template</option>
	  <c:forEach items="${AllTemplates}" var="template">     
	  <option class="login login-submit" value="${template.templateid}">${template.templatename}</option>
	  </c:forEach>
          <form:errors path="templateid" cssClass="error"/>	  
        </form:select>
        </div>  
     <hr><hr>
        <div class="col2"> <h4>Current Activity <br><br>${fn:escapeXml(activitybean.activityname)}</h4></div>
</div>
<div id="sumukha"> 
    <div>
    <h4>Available Engineers<br><br>
    <form:select style="width:130px" path="engtracker" >
        <option class="login login-submit" value="">None</option>
	           <c:forEach  items="${engineers}" var="eng"> 
	           <form:option id="engineer" class="login login-submit" value="${eng.userid}">${eng.username}  :  ${eng.team} </form:option>
	           </c:forEach>
        </form:select>
        <form:errors path="engtracker" cssClass="error"/></h4>
</div>  
 <div><h4>Start Date</h4><form:input placeholder="Enter Start Date" id="date" path="startdate" /><form:errors path="startdate" cssClass="error"/></div>
 <div><h4>End Date</h4><br><form:input placeholder="Enter End Date" id="datepicker" path="enddate"/><form:errors path="enddate" cssClass="error"/></div>
</div>
<!-- second table-->
<!-- second table-->
<!-- second table-->
<!-- second table-->
<!-- second table-->
<!-- second table-->

<br><br><br>
<hr><hr>
<div class="santosh"><form><input type="button" class="sumukh-submit" value="Add Row"></form><br><br><input type="submit" value="Submit" class="login login-submit"/></div>
<div id="overflowTest">
<table>
        <thead>
            <tr><hr>
                <th>Available Engineers</th>
                <th>Start date</th>
                <th>end date</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td><form:input type="hidden" id="date" path="startdate" /></td>
                <td><form:input type="hidden" id="datepicker" path="enddate"/></td>
            </tr>
        </tbody>
    </table><hr>
     <br><br><br><br>       

 </div>
</table >
</div>
<br><br><br><br> 
</form:form>
      
</div>
</body>
</html>


