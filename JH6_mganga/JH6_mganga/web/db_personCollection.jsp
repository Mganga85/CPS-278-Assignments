<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person Collection</title>
    </head>
    <body>
        <h1>Person Collection</h1>
        <form action="DB_PersonServlet">
            <input type="submit" name="action" value="Clear List"/>
        </form>
        <p>
        <form action="DB_PersonServlet">
            Name <input type="text" name="name" /> <br>
          Eye Color <input type="text" name="eyeColor" /> <br>
         Hair Color   <input type="text" name="hairColor" /> <br>
      Height  <input type="text" name="height" /> <br>
           Weight <input type="text" name="weight" /> <br>
           
           <br><input type="submit" name="action" value="add" />
        </form>
        <hr>                       
        <h3>${errorMessage}</h3>
        
        <table border="3">
            <tr><th>Name</th><th>Eye Color</th><th>Hair Color</th><th>Height</th><th>Weight</th></tr>
       
            <c:forEach var="person" items="${PersonCollection}"  varStatus="loopStatus" >
            <tr>
            <form action="DB_PersonServlet" >
                <td><input type="text"  name="name" value="${person.name}" /></td>
                <td><input type="text"  name="eyeColor" value="${person.eyeColor}" /></td>
                <td><input type="text"  name="hairColor" value="${person.hairColor}" /></td>
                <td><input type="text"  name="height" value="${person.height}" /></td>
                <td><input type="text"  name="weight" value="${person.weight}" /></td>
                <td><input type="submit" name="action" value="remove" />
                     <input type="submit" name="action" value="update" />
                     <input type="hidden" name="index" value="${person.index}" />
                </td>
            </form>
            </tr>
         </c:forEach>
        </table>
    </body>
</html>
