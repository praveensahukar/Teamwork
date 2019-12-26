<%-- 
    Document   : UpdateProjectDetails
    Created on : Sep 28, 2018, 6:35:48 PM
    Author     : santosh.babar
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
  padding: 0px 8px;
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
  width: 200px;
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

.login-drop {
  /* border: 1px solid #3079ed; */
  width: 300px;
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #a6a6a6;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

.login-drop:hover {
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
<script>
 (function($, undefined) {

    "use strict";

    // When ready.
    $(function() {
        
        var $form = $( "#form" );
        var $input = $( "#revenue" );

        $input.on( "keyup", function( event ) {
            
            
            // When user select text in the document, also abort.
            var selection = window.getSelection().toString();
            if ( selection !== '' ) {
                return;
            }
            
            // When the arrow keys are pressed, abort.
            if ( $.inArray( event.keyCode, [38,40,37,39] ) !== -1 ) {
                return;
            }
            
            var $this = $( this );
            
            // Get the value.
            var input = $this.val();
            
            var input = input.replace(/[\D\s\._\-]+/g, "");
                    input = input ? parseInt( input, 10 ) : 0;

                    $this.val( function() {
                         return ( input === 0 ) ? 0 : input.toLocaleString( "en-IN" );
                    } );
        } );
    });
})(jQuery);   
    </script>
    
    <script>
        
    function sanitize() {     
    var $input = $("#revenue").val();
    $x=$input.replace(/,/g , ''); 
    $y = parseInt($x,10);
    $('#revenue').val($y);
    document.getElementById("form").submit();
    $("#form").trigger('reset');
}     
</script>
    
<title>Update Project</title>
</head>

<%@include file="Header.jsp"%>
	  
<div class="login-card">
	   
<div align="left">  
    
    <h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Edit Project Details</h2></div>

    <div>
    <form:form action="UpdateProjectDetails.do" method="post" commandName="ProjectM" id="form" autocomplete="off">

    <table  border="0" cellpadding="10" cellspacing="3" align="left">

    <tr>
        <td align="right">Project Name :</td>
        <td colspan="3"><form:input placeholder="Enter Activity Name" path="projectname" value="${fn:escapeXml(ProjectData.projectname)}" />
            <span class='red'>*</span>
            <form:errors path="projectname" cssClass="error"/>
        </td>
    </tr>  
    
    <tr>
        <td align="right">OPID :</td>
        <td><form:input placeholder="Enter OPID" path="opid" value="${fn:escapeXml(ProjectData.opid)}"/>
            
            <form:errors path="opid" cssClass="error"/>
        </td>
    
        <td align="right">Company :</td>
        <td><form:select path="companyid" class="login login-drop">
        <form:option class="login login-submit" value="${fn:escapeXml(ProjectData.companyid)}" path="companyid">${CompanyName}</form:option>
	    <c:forEach  items="${AllCompany}" var="company"> 
            <form:option class="login login-submit" value="${company.companyid}">${company.companyname}</form:option>
	    </c:forEach>
        </form:select>
            <span class='red'>*</span>
        <form:errors path="companyid" cssClass="error"/>
        </td>
    </tr>

    <tr>
        <td align="right">Delivery Manager :</td>
        <td><form:select  path="deliverymanager" itemLabel="Select" class="login login-drop"> 
        <form:option class="login login-submit" value="${ProjectData.deliverymanager}" path="deliverymanager">${Dmanager}</form:option>
            <c:forEach items="${AllDManagers}" var="dmanager">     
            <option class="login login-submit" value="${dmanager.userid}">${dmanager.username}</option>
            </c:forEach>
        </form:select>
            <span class='red'>*</span>
        <form:errors path="deliverymanager" cssClass="error"/>
        </td>	  
    
        <td align="right">Project Manager :</td>
        <td><form:select  path="projectmanager" itemLabel="Select" class="login login-drop"> 
            <form:option class="login login-submit" value="${ProjectData.projectmanager}" path="projectmanager">${Pmanager}</form:option>
            <c:forEach items="${AllPManagers}" var="pmanager">     
            <option class="login login-submit" value="${pmanager.userid}">${pmanager.username}</option>
            </c:forEach>
            </form:select>
            <span class='red'>*</span>
            <form:errors path="projectmanager" cssClass="error"/>
        </td>	  
        
    </tr>
        
    <tr>
        <td align="right">Revenue (In INR):</td>
        <td><form:input placeholder="Enter Revenue in INR" path="revenue" value="${ProjectData.revenue}" id="revenue" type="text" maxlength="15"/>
            <form:errors path="revenue" cssClass="error"/>
        </td>
    
        <td align="right">Region :</td>
        <td><form:input placeholder="Enter Region" path="region" value="${ProjectData.region}" />
            <span class='red'>*</span>
            <form:errors path="region" cssClass="error"/>
        </td>
    </tr>

    <tr>
        <td align="right">Other Details :</td>
        <td colspan="2"><form:textarea rows="3" cols="40" id="discription" path="description" class="textarea"  />
            <form:errors path="description" cssClass="error"/>
        </td>
    

    <input type="hidden" name="AntiCSRFToken" value="${csrfPreventionSalt}"/> 
        
    <input type="hidden" name="projectid" value="${ProjectData.projectid}"/>

    
        <td align="center"><input type="button" value="Update"  onclick="sanitize()" class="login login-submit"/>
        </td>
    </tr>           

    
    </table>

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
    
     <script>
        function fillDiscription() {
        document.getElementById("discription").value = "${ProjectData.description}";
        }
        window.onload = fillDiscription();
    </script>
    </body>
</html>