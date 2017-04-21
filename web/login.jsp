<%-- 
    Document   : login
    Created on : Oct 13, 2016, 8:26:25 PM
    Author     : Mazsub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login!</h1>
        <form action="ControllerCustomers" method="post">
            Username: <input type="text" name="txtUser"/>
            Password: <input type="password" name="txtPass"/>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" name="action" value="Reset"/>
        </form>
    </body>
</html>
