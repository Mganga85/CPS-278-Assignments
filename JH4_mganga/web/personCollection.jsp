
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="people.*"  %>
<%
  PeopleCollection personCollection = PeopleCollection.update(pageContext);
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="formStyle.css"> <!--will use CSS style sheet called form Style. -->

        <title>Person Collection</title>
    </head>
    <body>
        <h1 class = "main">Person Collection</h1>
        
       
        <form action="personCollection.jsp">
            <br><input type="text" name="name" /> Name 
            <br><input type="text" name="eyeColor" required/> Eye Color
            <br><input type="text" name="hairColor" required/> Hair Color
            <br><input type="text" name="height" required/> Height
            <br><input type="text" name="weight" required /> weight
            <br><input type="submit" name="action" value="add" />
        </form> 
        <form action ="personCollection.jsp">
           <input type ="submit" name ="action" value ="CLEAR ALL"/>
        </form>
        <hr>
        <h3><%=personCollection.getErrorMessage()%></h3>
        
        <table border="3">
            <tr><th>Name</th><th>Eye Color</th><th>Hair Color</th><th>Height</th><th>Weight</th></tr>
        <%
            for (int i=0; i < personCollection.size(); i++)
            {
                Person  person = personCollection.getPerson(i);
                
            
         %>
            <tr>
            <form action="personCollection.jsp">
                <td><input type="text"  name="name" value="<%=person.getName()%>" /></td>
                <td><input type="text"  name="eyeColor" value="<%=person.getEyeColor()%>" /></td>
                <td><input type="text"  name="hairColor" value="<%=person.getHairColor()%>" /></td>
               
                <td><input type="text" name="height" value="<%=person.getHeight()%>" /></td>
                <td><input type="text" name="weight" value="<%=person.getWeight()%>" /></td>

                <td><input type="submit" name="action" value="remove" />
               <input type="submit" name="action" value="update" />
               <input type="hidden" name="index" value="<%= i %>" />
            </td>
        


            </form>
            </tr>
         <%
            }
          %>
        </table>
    </body>
</html>
