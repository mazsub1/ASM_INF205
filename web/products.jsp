<%-- 
    Document   : products
    Created on : Oct 13, 2016, 8:36:30 PM
    Author     : Mazsub
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Products!</h1>
        <form action="ControllerProducts">
            Nhập tên sản phẩm: <input type="text" name="txtName"/>
            <input type="submit" name="action" value="Search"/>
            <br/>
            <br/>
        </form>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>
                <td>Edit</td>
                <td>Delete</td>
                <td>New</td>
            </tr>
            <c:forEach var="rows" items="${listSP}">
                <form action="ControllerProducts">
                    <tr>
                        <td>${rows.code}</td>
                        <td>${rows.name}</td>
                        <td>${rows.price}</td>         
                        <c:url var="del" value="ControllerProducts">
                            <c:param name="action" value="Edit"/>
                            <c:param name="txtCode" value="${rows.code}"/>
                            <c:param name="txtName" value="${rows.name}"/>
                            <c:param name="txtPrice" value="${rows.price}"/>
                        </c:url>
                        <td><a href="${del}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtCode" value="${rows.code}"/>
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                        <td><input type="submit" name="action" value="New"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
