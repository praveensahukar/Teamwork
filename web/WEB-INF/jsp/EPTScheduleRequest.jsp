

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
    
    <script src="js/getOpidForProject.js" type="text/javascript"></script>
    
    <script src="js/addOpidForProject.js" type="text/javascript"></script>
    
    
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
#1,#2{
    position: relative;
      left: 0;
    top: 0;
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
    
<title>Request Schedule</title>
</head>

<body>

	   
<div class="login-card">
	   
   
<!--action="getEngineers.do"-->
    <form:form  method="post" action="EPTActivity.do" modelAttribute="EPTBean">
          <input type="hidden" name="AntiCSRFToken" id="token" value="${csrfPreventionSalt}"/>
          <input type="hidden" name="pid" value="${pid}"/>
    <div style="width :60%;margin-left: 100px;"> 
        <center>  <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Schedule Request Network Activity</h2></center>
                <table align="right" border="0" cellpadding="10" cellspacing="2">
                    <tr>
            <td colspan="2" align="left">Project:     
            <form:select class="login login-submit" id="projectID" path="projectid">
                <option class="login login-submit"  value="0">Select</option>
                <c:forEach  items="${AllProjects}" var="project"> 
                <form:option class="login login-submit"  value="${project.projectid}">${project.projectname}</form:option>    
                </c:forEach>
                </form:select>
                <form:errors path="projectid" cssClass="error"/>
           </td>
        </tr>
                    <tr>
                        <td>
                            <label>Preferred start Date:</label>
                            <form:input placeholder="Enter Start Date" id="txtFromDate3" path="prefstartdate" />
                        </td>
                        <td>
                            <label>Type of Assessment:</label>
                            <form:select class="login login-submit" path="assesstype" id="assess2">
                <form:option class="login login-submit" value="">Select</form:option>
                            <form:option class="login login-submit" value="Internal Network Penetration Testing">Internal Network Penetration Testing</form:option>
                            <form:option class="login login-submit" value="External Network Penetration Testing">External Network Penetration Testing</form:option>
                           
                    
                </form:select>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            <label>Efforts:</label>
                           <form:input placeholder="Efforts" path="effort" />
                              <span class='red'>*</span>
                              <form:errors path="" cssClass="error"/>
                        </td>
                        <td>
                            <a href="/TeamWorkAlpha/uploadfiles.do?pid=${ProjectData.activityid}" 
                                target="popup" 
                                onclick="window.open('/TeamWorkAlpha/uploadfiles.do?pid=${ProjectData.activityid}','popup','width=800,height=600'); return false;">
                                 Upload files
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Hosting Environment:</label>
                            <form:input type="text" name="eft" id="task1" placeholder="Hosting Environment" path="hosting" />
                        </td>
                        <td>
                             <label>Pre-requisites:</label>
                            <form:input type="text" name="eft" id="task2" placeholder="Pre-requisites" path="pre_req" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Whitelisting Confirmation:</label>
                            <form:input type="text" name="eft" id="task9" placeholder="Whitelisting Confirmation" path="whitelistconf" />
                        </td>
                        <td>
                             <label>Time window:</label>
                            <form:input type="text" name="eft" id="task10" placeholder="Time window" path="timewindow" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Domain:</label>
                            <form:input type="text" name="eft" id="task7" placeholder="Domain" path="domain"/>
                        </td>
                        <td>
                             <label>IP's in proposal:</label>
                            <form:input type="text" name="eft" id="task8" placeholder="IP's in proposal" path="ipproposal" />
                        </td>
                    </tr>
                    <tr>
        
            <td colspan="4" align="center"><input type="submit" value="Raise Schedule Request" class="login login-submit"/></td>
        </tr>
                </table>   
        </form:form>
          </div>
</div>
     

<script>
  $(document).ready(function(){
    $("#txtFromDate3").datepicker({
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#txtToDate3").datepicker("option","minDate", selected)
        }
    });
    $("#txtToDate3").datepicker({ 
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#txtFromDate3").datepicker("option","maxDate", selected)
        }
    });  
});
</script>

</body>
</html>
