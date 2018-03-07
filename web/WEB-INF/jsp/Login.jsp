<%-- 
    Document   : Login
    Created on : 12 Apr, 2017, 8:31:39 PM
    Author     : Administrator
--%>
<%@page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<!DOCTYPE html>
<html>

<head>
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
  
  top: 30%;
  padding: 40px;
  width: 500px;
  height:500px;
  background-image: url("2.jpg");
  margin: 0 auto 10px;
  border-radius: 0px;
  
  overflow: hidden;
}

.login-card h1 {
  font-weight: 100;
  text-align: center;
  font-size: 2.3em;
}

.login-card input[type=submit] {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;
}

.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 100%;
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
  border: 1px solid #b9b9b9;
  border-top: 1px solid #a0a0a0;
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
  background-color: #ff0000;
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
.error {
color: black;
font-style: italic;
}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   height: 8%;
   background-color: #79a6d2;
   color: white;
   text-align: center;
}
</style>
  <meta charset="UTF-8">

  <title>Log-in</title>
  
 

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>
<br><br>
  <div class="login-card">
  <div align="left">
<img src="PaladionLogo.png"/>
    </div>
    <h1>Teamwork</h1>
    <center><h4 style="color: #ff0000">${Message}</h4></center>
<!-- UI goes here-->
    <form:form action="Login.do" method="post" commandName="LoginM"> 
        <form:errors path="email" cssClass="error"/><br>
        Email ID:<form:input path="email" placeholder="Enter the username"/><br>
        
        Password:<form:password path="password" placeholder="Enter the password"/><br>
        <form:errors path="password" cssClass="error"/>
        <input type="hidden" name="csrfPreventionSalt" value="<c:out value='${csrfPreventionSalt}'/>"/>
<!--        <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LdILiQUAAAAADnLG0a6cHtsTag3ey10y652yvGK", "6LdlHOsSAAAAACe2WYaGCjU2sc95EZqCI9wLcLXY", true);
          out.print(c.createRecaptchaHtml(null, null));
          %> -->
        <div align="left"><button type="submit" name=login value="Login"class="login login-submit">Login</button></div><br>
	   
        
    </body>
    </form>
    <form:form action="ForgotPassword.do" method="GET">
        <div align="left">   <button type="submit" value="forgot" class="login login-submit">Forgot Password</button></a></div>
    </form:form>
    </form:form>
<div class="footer">
  <p>Copyright © 2007-2018 Paladion Team Version: 1.0 All rights reserved. </p>
</div>
</html>
  </div>

</body>


