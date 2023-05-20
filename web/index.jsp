<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Product List</title>
    </head>
    <body>
        <h1>Product List</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div>
            <c:if test="${currentPage > 1}">
                <a href="ProductServlet?page=${currentPage - 1}">Previous</a>
            </c:if>
            <c:if test="${currentPage < totalPages}">
                <a href="ProductServlet?page=${currentPage + 1}">Next</a>
            </c:if>
        </div>
    </body>
</html>
