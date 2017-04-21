<%-- 
    Document   : index
    Created on : Oct 16, 2016, 12:11:13 PM
    Author     : Mazsub
--%>

<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="model.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Products!</h1>
        <table border="1">
            <tr>
                <td>Mã sản phẩm</td>
                <td>Tên sản phẩm</td>
                <td>Giá</td>
            </tr>
            <%
                Products listSP = new Products();
                List<Product> list = listSP.showProduct("");
                for (Product sp : list) {
                    out.print("<tr><td>" + sp.getCode() + "</td><td>" + sp.getName() + "</td><td>" + sp.getPrice() + "</td><td><input type=\"submit\" "
                            +"value=\"Add to Cart"
                            + "</tr>");
                }
            %>
        </table>
    </body>
</html>
