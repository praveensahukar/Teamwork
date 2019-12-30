






















<%-- 
    Document   : Login
    Created on : 12 Apr, 2017, 8:31:39 PM
    Author     : Administrator
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="icon" href="Network-Security.png" type="image/x-icon">
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
<html> 
  
<head> 
    <title>How to display div elements 
      using Dropdown Menu in jQuery?</title> 
    <script src= 
"https://code.jquery.com/jquery-1.12.4.min.js"> 
  </script> 
</head> 
  
<body> 
<script>
    function onLoadData()
{
 
document.getElementById('C GFG').innerHTML = '/code_review.jsp';
 
}


 $(document).ready(function() {
    $('#activityType').on('change', function() {
      alert( this.value ); // or $(this).val()
      
      
       var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            document.getElementById("page").innerHTML =
            this.responseText;
            }
        };
        xhttp.open("GET", "/LoadScheduleRequestPage.do?param="+this.value, true);
        //Here param is used to pass the value of selected element
        //We can also use here POST/PUT/DELETE methods..with some modification.
        xhttp.send();
      
      
      
      
      
      
    });
});
</script>

    <center> 
        <h1 style="color:green;">  
         
    </h1> 
        <h3> Activity Type:</h3> 
        <div> 
            <select id="activityType"> 
                <option>Select</option> 
                <option value="CodeReview">Code review</option> 
                <option value="Network">Network</option> 
                <option value="Grey">Gray-Box testing</option>  
            </select> 
        </div> 
        <div> 
            <div id = "page"> </div> 
            <div class="Cplus GFG" 
                 style="padding: 30px; 
                        margin-top: 30px;  
                        width :60%; 
                        background:green"> 
              
                            <%@include file="network.jsp" %>
          </div> 
            <div class="Python GFG"
                 style="padding: 30px; 
                        margin-top: 30px;  
                        width :60%; 
                        background:green"> 
                               <%@include file="graybox.jsp" %>
          </div> 
            <div class="Java GFG"
                 style="padding: 30px; 
                        margin-top: 30px;  
                        width :60%; 
                        background:green"> 
                            <label>Preferred start Date:</label>
                            <input type="text" name="eft">
                            <label>Type of Assessment:</label>
                            <input type="text" name="eft">
                            <label>Efforts:</label>
                            <input type="text" name="eft">
                            <label>Priority:</label>
                            <input type="text" name="eft">
          </div> 
        </div> 
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
        function loadIntoDiv(var pagename) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            document.getElementById("fetchHere").innerHTML =
            this.responseText;
            }
        };
        xhttp.open("GET", "/ServletController?pageName=pagename", true);
        //Here param is used to pass the value of selected element
        //We can also use here POST/PUT/DELETE methods..with some modification.
        xhttp.send();
}
        
      </script>  
        
    </center> 
</body> 
  
</html> 
