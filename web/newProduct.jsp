<%-- 
    Document   : newProduct
    Created on : Oct 16, 2016, 6:36:46 PM
    Author     : Mazsub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New Product!</h1>
        <form action="ControllerProducts">
            Code: <input type="text" name="txtCode"/><br>
            Name: <input type="text" name="txtName"/><br>
            Price: <input type="text" name="txtPrice"/><br>
            <input type="submit" name="action" value="Insert"/>
        </form>
    </body>
</html>
