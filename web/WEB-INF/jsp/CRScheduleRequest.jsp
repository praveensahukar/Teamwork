

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
  $(document).ready(function(){
    $("#txtFromDate").datepicker({
        numberOfMonths: 1,
        onSelect: function() {
          $("#txtFromDate").datepicker()
        }
    });  
});
</script>
<script src="js/getOpidForProject.js" type="text/javascript"></script>
<script src="js/addOpidForProject.js" type="text/javascript"></script>

<!--<script>  
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
 </script>  -->

</head>
<body>
<div class="login-card" >
<!--action="getEngineers.do"-->
    <form:form  method="post" action="saveCodeReviewActivity.do" modelAttribute="CRBean">
    <input type="hidden" name="AntiCSRFToken" id="token" value="${csrfPreventionSalt}"/>
    <input type="hidden" name="pid" value="${pid}"/>
    <div style="width :60%;margin-left: 100px;"> 
        <center><h2 style="color: #a6a6a6; font-family: sans-serif; font-style: normal">Schedule Request - Source Code Review</h2></center>
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
                            <form:input placeholder="Enter Start Date" id="txtFromDate" path="prefstartdate" />
                        </td>
                        <td>
                            <label>Code Review Type:</label>
                            <form:select class="login login-submit" path="assesstype" id="assess">
                                <form:option class="login login-submit" value="">Select</form:option>
                                <form:option class="login login-submit" value="webcr">Web Application Code Review</form:option>
                                <form:option class="login login-submit" value="androidcr">Android Application Code Review</form:option>
                                <form:option class="login login-submit" value="ioscr">iOS Application Code Review</form:option>
                                <form:option class="login login-submit" value="apicr">Web Service / API Code Review</form:option>
                                <form:option class="login login-submit" value="apicr">Premium Code Scans</form:option>
                                <form:option class="login login-submit" value="othercr">Other</form:option>
                            </form:select>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                <label>Name of application:</label>
                <form:input type="text" name="eft" id="task1" placeholder="Name of application" path="appname" />
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
                            <form:input type="text" name="eft" id="task1" placeholder="Hosting Environemnt" path="hosting" />
                        </td>
                        <td>
                             <label>Pre-requisites:</label>
                            <form:input type="text" name="eft" id="task2" placeholder="Pre-requisites" path="pre_req" />
                        </td>
                    </tr>
                    
        <tr>
            <td>
                            <label>Efforts:</label>
<!--                        <input type="text" name="eft" id="efrt">-->
                            <form:input placeholder="Efforts" path="effort" />
                            <span class='red'>*</span>
                            <form:errors path="" cssClass="error"/>
                        </td>
            <td>
                <label>Lines of codes:</label>
                <form:input type="text" name="eft" id="task2" placeholder="Lines of codes" path="scope" />
            </td>
        </tr>
        <tr>
            <td>
                <label>Code access:</label>
                <form:select class="login login-submit" path="access" name="eft"> 
                <form:option class="login login-submit" value="">Select</form:option>
                <form:option class="login login-submit" value="Remote Access/VPN">Remote Access/VPN</form:option>
                <form:option class="login login-submit" value="Base Camp">Base Camp</form:option>
                <form:option class="login login-submit" value="Code Repository Access">Code Repository Access</form:option>
                <form:option class="login login-submit" value="Offline">Offline</form:option>
                <form:option class="login login-submit" value="Others">Others</form:option>
                </form:select>
            </td>
            
            <td>
                <label>Technology / Language</label>
                <form:select class="login login-submit" path="technology"> 
                <form:option class="login login-submit" value="">Select</form:option>
                <form:option class="login login-submit" value="Java / J2EE">Java / J2EE </form:option>
                <form:option class="login login-submit" value="ASP.NET / Visual Basic / C#">ASP.NET / Visual Basic / C#</form:option>
                <form:option class="login login-submit" value="Android / Kotlin">Android / Kotlin</form:option>
                <form:option class="login login-submit" value="SWIFT / Objective C">SWIFT / Objective C</form:option>
                <form:option class="login login-submit" value="PHP">PHP</form:option>
                <form:option class="login login-submit" value="Ruby On Rails">Ruby On Rails</form:option>
                <form:option class="login login-submit" value="GO Lang">GO Lang</form:option>
                <form:option class="login login-submit" value="Python / Django">Python / Django</form:option>
                <form:option class="login login-submit" value="C / C++">C / C++</form:option>
                <form:option class="login login-submit" value="Others">Others</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="4" align="center"><input type="submit" value="Add Activity Details"  class="login login-submit"/></td>
        </tr>
    </table>    
    </form:form>
</div>
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


