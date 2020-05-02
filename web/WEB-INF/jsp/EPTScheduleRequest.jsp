

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
                <h1>Schedule Request EPT/Exploratory Activity</h1>
                <table align="right" border="0" cellpadding="10" cellspacing="2">
                    <tr>
                        
                            <td align="right" >Project Name :</td>
                            <td colspan="1"><form:input placeholder="Enter Project Name" path="projectname"/>
                            <span class='red'>*</span>
                            <form:errors path="projectname" cssClass="error"/>
                            </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Preferred start Date:</label>
                            <form:input placeholder="Enter Start Date" id="txtFromDate2" path="prefstartdate" />
                        </td>
                        <td>
                            <label>Type of Assessment:</label>
                            <form:select class="login login-submit" path="assesstype" id="assess2">
                <form:option class="login login-submit" value="">Select</form:option>
                            <form:option class="login login-submit" value="WebCR">Web Application Code Review</form:option>
                            <form:option class="login login-submit" value="AndroidCR">Android Application Code Review</form:option>
                            <form:option class="login login-submit" value="iOSCR">iOS Application Code Review</form:option>
                            <form:option class="login login-submit" value="iOSCR">Other</form:option>
                    
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
        
            <td colspan="4" align="center"><input type="submit" value="Add Activity Details" class="login login-submit"/></td>
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
<script>
  $(document).ready(function(){
    $("#txtFromDate1").datepicker({
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#txtToDate1").datepicker("option","minDate", selected)
        }
    });
    $("#txtToDate1").datepicker({ 
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#txtFromDate1").datepicker("option","maxDate", selected)
        }
    });  
});
</script>
<script>
  $(document).ready(function(){
    $("#txtFromDate2").datepicker({
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#txtToDate2").datepicker("option","minDate", selected)
        }
    });
    $("#txtToDate2").datepicker({ 
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#txtFromDate2").datepicker("option","maxDate", selected)
        }
    });  
});
</script>
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
<script>
  $(document).ready(function(){
    $("#txtFromDate4").datepicker({
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#txtToDate4").datepicker("option","minDate", selected)
        }
    });
    $("#txtToDate4").datepicker({ 
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#txtFromDate4").datepicker("option","maxDate", selected)
        }
    });  
});
</script>
<script type="text/javascript"> 
            $(document).ready(function() { 
                $("select").on('change', function() { 
                    $(this).find("option:selected").each(function() { 
                        var geeks = $(this).attr("value"); 
                        if (geeks) { 
                            $(".GFG").not("." + geeks).hide(); 
                            $("." + geeks).show(); 
                        } else { 
                            $(".GFG").hide(); 
                        } 
  
                    }); 
                }).change(); 
            }); 
        </script> 
    <script>
		
		var list1 = [];
		var list2 = [];
		var list3 = [];
		var list4 = [];
                var list5 = [];
                var list6 = [];

		var n = 1;
		var x = 0;

		function AddRow(){

			var AddRown = document.getElementById('show');
			var NewRow = AddRown.insertRow(n);

			list1[x] = document.getElementById("txtFromDate1").value;
			list2[x] = document.getElementById("assess1").value;
			list3[x] = document.getElementById("efrt1").value;
			list4[x] = document.getElementById("fileSelect1").value;
                        list5[x] = document.getElementById("appname").value;
                        list6[x] = document.getElementById("sizeofapp").value;

			var cel1 = NewRow.insertCell(0);
			var cel2 = NewRow.insertCell(1);
			var cel3 = NewRow.insertCell(2);
			var cel4 = NewRow.insertCell(3);
                        var cel5 = NewRow.insertCell(4);
                        var cel6 = NewRow.insertCell(5);

			cel1.innerHTML = list1[x];
			cel2.innerHTML = list2[x];
			cel3.innerHTML = list3[x];
			cel4.innerHTML = list4[x];
                        cel5.innerHTML = list5[x];
                        cel6.innerHTML = list6[x];

			n++;
			x++;
		}
                

	</script>
<script>
		
		var list7 = [];
		var list8 = [];
		var list9 = [];
		var list10 = [];
                var list11 = [];
                var list12 = [];
                var list13 = [];
                var list14 = [];

		var m = 1;
		var y = 0;
                function AddRow1(){

			var AddRown = document.getElementById('show1');
			var NewRow = AddRown.insertRow(m);

			list7[y] = document.getElementById("txtFromDate").value;
			list8[y] = document.getElementById("assess").value;
			list9[y] = document.getElementById("efrt").value;
			list10[y] = document.getElementById("fileSelect").value;
                        list11[y] = document.getElementById("task1").value;
                        list12[y] = document.getElementById("task2").value;
                        list13[y] = document.getElementById("task5").value;
                        list14[y] = document.getElementById("task6").value;

			var cel7 = NewRow.insertCell(0);
			var cel8 = NewRow.insertCell(1);
			var cel9 = NewRow.insertCell(2);
			var cel10 = NewRow.insertCell(3);
                        var cel11 = NewRow.insertCell(4);
                        var cel12 = NewRow.insertCell(5);
                        var cel13 = NewRow.insertCell(6);
                        var cel14 = NewRow.insertCell(7);

			cel7.innerHTML = list7[y];
			cel8.innerHTML = list8[y];
			cel9.innerHTML = list9[y];
			cel10.innerHTML = list10[y];
                        cel11.innerHTML = list11[y];
                        cel12.innerHTML = list12[y];
                        cel13.innerHTML = list13[y];
                        cel14.innerHTML = list14[y];

			m++;
			y++;
		}
                

	</script>
<script>
		
		var list13 = [];
		var list14 = [];
		var list15 = [];
		var list16 = [];
                var list17 = [];
                var list18 = [];
                var list19 = [];
                var list20 = [];

		var p = 1;
		var z = 0;

		function AddRow2(){

			var AddRown = document.getElementById('show2');
			var NewRow = AddRown.insertRow(p);

			list13[z] = document.getElementById("txtFromDate2").value;
			list14[z] = document.getElementById("assess2").value;
			list15[z] = document.getElementById("efrt2").value;
			list16[z] = document.getElementById("fileSelect2").value;
                        list17[z] = document.getElementById("task9").value;
                        list18[z] = document.getElementById("task10").value;
                        list19[z] = document.getElementById("task7").value;
                        list20[z] = document.getElementById("task8").value;

			var cel13 = NewRow.insertCell(0);
			var cel14 = NewRow.insertCell(1);
			var cel15 = NewRow.insertCell(2);
			var cel16 = NewRow.insertCell(3);
                        var cel17 = NewRow.insertCell(4);
                        var cel18= NewRow.insertCell(5);
                        var cel19= NewRow.insertCell(6);
                        var cel20= NewRow.insertCell(7);

			cel13.innerHTML = list13[z];
			cel14.innerHTML = list14[z];
			cel15.innerHTML = list15[z];
			cel16.innerHTML = list16[z];
                        cel17.innerHTML = list17[z];
                        cel18.innerHTML = list18[z];
                        cel19.innerHTML = list19[z];
                        cel20.innerHTML = list20[z];

			p++;
			z++;
		}
                

	</script>

<script>
		
		var list21 = [];
		var list22 = [];
		var list23 = [];
		var list24 = [];
                var list25 = [];
                var list26 = [];
     

		var e = 1;
		var f = 0;

		function AddRow3(){

			var AddRown = document.getElementById('show3');
			var NewRow = AddRown.insertRow(e);

			list21[f] = document.getElementById("txtFromDate3").value;
			list22[f] = document.getElementById("assess3").value;
			list23[f] = document.getElementById("efrt3").value;
			list24[f] = document.getElementById("fileSelect3").value;
                        list25[f] = document.getElementById("task11").value;
                        list26[f] = document.getElementById("task12").value;
                       

			var cel21 = NewRow.insertCell(0);
			var cel22 = NewRow.insertCell(1);
			var cel23 = NewRow.insertCell(2);
			var cel24 = NewRow.insertCell(3);
                        var cel25 = NewRow.insertCell(4);
                        var cel26= NewRow.insertCell(5);
                    
			cel21.innerHTML = list21[f];
			cel22.innerHTML = list22[f];
			cel23.innerHTML = list23[f];
			cel24.innerHTML = list24[f];
                        cel25.innerHTML = list25[f];
                        cel26.innerHTML = list26[f];
                    

			e++;
			f++;
		}
                

	</script>

<script>
		
		var list27 = [];
		var list28 = [];
		var list29 = [];
		var list30 = [];
                var list31 = [];
                var list32 = [];
     

		var e = 1;
		var f = 0;

		function AddRow4(){

			var AddRown = document.getElementById('show4');
			var NewRow = AddRown.insertRow(e);

			list27[f] = document.getElementById("txtFromDate4").value;
			list28[f] = document.getElementById("assess4").value;
			list29[f] = document.getElementById("efrt4").value;
			list30[f] = document.getElementById("fileSelect4").value;
                        list31[f] = document.getElementById("task13").value;
                        list32[f] = document.getElementById("task14").value;
                       

			var cel27 = NewRow.insertCell(0);
			var cel28 = NewRow.insertCell(1);
			var cel29 = NewRow.insertCell(2);
			var cel30 = NewRow.insertCell(3);
                        var cel31 = NewRow.insertCell(4);
                        var cel32= NewRow.insertCell(5);
                    
			cel27.innerHTML = list27[f];
			cel28.innerHTML = list28[f];
			cel29.innerHTML = list29[f];
			cel30.innerHTML = list30[f];
                        cel31.innerHTML = list31[f];
                        cel32.innerHTML = list32[f];
                    

			e++;
			f++;
		}
               
	</script>
</body>
</html>
