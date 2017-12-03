<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Collection</title>
    </head>
    <body>
        <h1>Book Collection</h1>
        <form action="DB_BookServlet">
            <input type="submit" name="action" value="Clear List"/>
        </form>
        <p>
        <form action="DB_BookServlet">
            <input type="text" name="title" /> Title
            <br><input type="text" name="author" /> Author
            <br><input type="text" name="isbn" /> ISBN
            
            <br><input type="text" name="edition" /> Edition
            <br><input type="submit" name="action" value="add" />
        </form>
        <hr>                       
        <h3>${errorMessage}</h3>
        
        <table border="3">
            <tr><th>Title</th><th>Author</th><th>Isbn</th><th>Edition</th><th></th></tr>
       
            <c:forEach var="book" items="${BookCollection}"  varStatus="loopStatus" >
            <tr>
            <form action="DB_BookServlet" >
                <td><input type="text"  name="title" value="${book.title}" /></td>
                <td><input type="text"  name="author" value="${book.author}" /></td>
                <td><input type="text"  name="isbn" value="${book.isbn}" /></td>
              
                <td><input type="text"  name="edition" value="${book.edition}" /></td>
                <td><input type="submit" name="action" value="remove" />
                     <input type="submit" name="action" value="update" />
                     <input type="hidden" name="index" value="${book.index}" />
                </td>
            </form>
            </tr>
         </c:forEach>
        </table>
    </body>
</html>

