<%-- 
    Document   : CreateScheduleAllocationAppSec
    Created on : May 8, 2020, 5:20:42 PM
    Author     : pal
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
  $(document).ready(function(){
    $("#txtFromDate").datepicker({
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#txtToDate").datepicker("option","minDate", selected)
        }
    });
    $("#txtToDate").datepicker({ 
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#txtFromDate").datepicker("option","maxDate", selected)
        }
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
  width: 60%;
  display: block;
  margin-bottom: 10px;
  position: relative;
  float: center;
}
.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 90%;
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
    width: 80%;
    color: #ff0000;
    border-color: white;
    align-items: left;
}
th {
    text-align: center;
}
.error {
color: red;
font-style: italic;
}
</style>

 <script >  
   function doAjaxPost() {  
    var sdate = $('#date').val();  
    var edate = $('#datepicker').val();  
    var team = $('#team').val();
    var csrfPreventionSalt = $('#token').val();
    alert(csrfPreventionSalt);
    
    if(!team)
    {
        alert("Select Team!!"); 
        return; 
    }
    
    if(!sdate)
    {
        alert("Select Start Date!!"); 
        return; 
    }
    
    if(!edate)
    {
        alert("Select End Date!!"); 
        return; 
    }
    
    var dropdown = $('#engineers');
    
    
   $.ajax({
     dataType : 'json',
     type : "Post",   
     url : "getEngineers.do",   
     data : "sdate=" + sdate + "&edate=" + edate + "&team=" + team + "&AntiCSRFToken=" + csrfPreventionSalt,  
     success : function(data){
         alert(data);
            var users = JSON.parse(data);
              alert(users);
              
              $.each(data.users,function(i,obj)
                {
                        $.each(obj, function (key, val) {
                        alert(key + val);
                        });
                });
            }
            ,  
     error : function(e) {  
      alert('Error: ' + e);   
     }  
    }); 
   }  
 </script>  
    
<title>Schedule Activity</title>
</head>

<body>
<%@include file="Header.jsp"%>
	   
<div class="login-card">
	   
    <div>  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Schedule Activity</h2></div>

    <form:form action="getEngineers.do" method="post" commandName="ProjectM">
    <div>
        
        <input type="hidden" name="AntiCSRFToken" id="token" value="${csrfPreventionSalt}"/>
    
        <table border="0" cellpadding="10" cellspacing="2" >

        <tr>
            <td align="right">Project :</td>
            <td><form:input path="" value="${fn:escapeXml(projectname)}" />
            </td>
        
            <td align="right">Activity Name :</td>
            <td><form:input placeholder="Enter Activity Name" path="activityname" value="${fn:escapeXml(ASData.assesstype)}"/>
            <span class='red'>*</span> 
            <form:errors path="activityname" cssClass="error"/>
            </td>
        </tr>  

         <tr>
            <td align="right">Start Date :</td>
            <td><form:input placeholder="Enter Start Date" id="txtFromDate" path="startdate" />
            <span class='red'>*</span>
            <form:errors path="startdate" cssClass="error"/>
            </td>
        
            <td align="right">End Date :</td>
            <td><form:input placeholder="Enter End Date" id="txtToDate" path="enddate"/>
            <span class='red'>*</span>
            <form:errors path="enddate" cssClass="error"/>
            </td>
        </tr>
        
        
        
        <tr>
            <td align="right">Team :</td>
            <td><form:select path="team" id="team" class="login login-submit">
                <option class="login login-submit" value="">Select</option>
	        <c:forEach  items="${AllTeams}" var="team"> 
	        <form:option class="login login-submit" value="${team.teamname}">${team.teamname}</form:option>
	        </c:forEach>
                </form:select>
                <span class='red'>*</span>
                <form:errors path="team" cssClass="error"/>
            </td>
        
            <td align="right">Lead :</td>
            <td><form:select path="leadid" class="login login-submit">
                <option class="login login-submit" value="0">Select</option>
                <c:forEach  items="${AllLeads}" var="lead"> 
                <form:option class="login login-submit" value="${lead.userid}">${lead.username}</form:option>
                </c:forEach>
                </form:select>
                <span class='red'>*</span>
                <form:errors path="leadid" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td align="right">Type of Assessment:</td>
            <td><form:input path="assessmentType" value="Initial" />
                
                <span class='red'>*</span>
            </td>
        
            <td align="right">Regulation Compliance:</td>
            <td><form:select class="login login-submit" placeholder="PCIDSS/HIPPA" path="compliance">
                <form:option class="login login-submit" value="">Select</form:option>
                <form:option class="login login-submit" value="PCI DSS">PCI DSS</form:option>
                <form:option class="login login-submit" value="HIPAA">HIPAA</form:option>
                <form:option class="login login-submit" value="Plynt Certification">PLYNT Certification</form:option>
                <form:option class="login login-submit" value="Others">Others</form:option>
                <form:option class="login login-submit" value="None">None</form:option>
                </form:select>
                <span class='red'>*</span>
            </td>
        </tr> 

        <tr>
            <td align="right">Pre-requisites:</td>
            <td><form:select class="login login-submit"  path="requirements">
                <form:option class="login login-submit" value="">Select</form:option>
                <form:option class="login login-submit" value="Shared and Validated">Received and Validated</form:option>
                <form:option class="login login-submit" value="Shared, Needs Validation">Received, Needs Validation</form:option>
                <form:option class="login login-submit" value="Shared, Needs Validation">Not Received</form:option>
                </form:select>    
            </td>
        
            <td align="right">Whitelisting Confirmation:</td>
            <td><form:select class="login login-submit"  path="whitelisting">
                <form:option class="login login-submit" value="">Select</form:option>
                <form:option class="login login-submit" value="Yes">Yes</form:option>
                <form:option class="login login-submit" value="No, Need Confirmation">No, Need Confirmation</form:option>
                </form:select>
            </td>
        </tr> 

        <tr>
            <td align="right">Scope/Other Details :</td>
            <td colspan="2"><form:textarea rows="3" cols="40" class="textarea" path="details" name="details"/></td>
        
            <td align="left"><input type="submit" value="Create" class="login login-submit"/></td>
        </tr>           

        </table>

    </div>

    </form:form>

</div>
     
<script>
  $(document).ready(function(){
    $("#txtFromDate").datepicker({
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#txtToDate").datepicker("option","minDate", selected)
        }
    });
    $("#txtToDate").datepicker({ 
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#txtFromDate").datepicker("option","maxDate", selected)
        }
    });  
});
</script>
    
</body>

</html>


