<%-- 
    Document   : OneLiner
    Created on : Sep 29, 2017, 5:26:51 PM
    Author     : Matt Ganga
    Class      : CPS 278
    Assignment : JH4 
    Part       : One Liner

This program will read in file from a txt file stored in WEB/INF directory.
after the file is read in, it will store each line into an ArrayList.
Everytime the user visits the page, a different one line from ArrayList will be displayed.

**Extra was added in to change backgound color, and font color everytime as well. 
**font and background color will never be the same. 
--%>


<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="calculations.Calc"%>"

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   
    String oneLine = " ";
    int nextOneLiner = 0;
    String next = "";
    int i = 0;
    int bodyColorIndex = 0;


%>
<%

    ArrayList<String> oneLiners = new <String> ArrayList();
    String [] colors = null;
    //will find path for our file to read from
    ServletContext sc = getServletContext();
    String path = sc.getRealPath("/WEB-INF");
    path += System.getProperty("file.separator") + "list.txt";

    
   //creates an object of the Calc class 
   Calc run = new Calc();
   
   //Calls methods in Calc class and passes in path name to create array
   oneLiners =  run.getArray(path);
   
   //gets color array from Calc class
   colors= run.getColorsArray();
            

    // while oneLiner index is less than ArrayList, increment index for Arraylist, color index, bodyColorIndex.
    nextOneLiner += 1;
    while (nextOneLiner < oneLiners.size()) {
        next = oneLiners.get(nextOneLiner);
        i++;
        bodyColorIndex += 2;

        // extra for changing colors, not neccessary. 
        if (i >= colors.length) {
            i = 0;
        }
        if (bodyColorIndex >= colors.length) {
            bodyColorIndex = 0;
        }
        if (bodyColorIndex == i) {
            bodyColorIndex++;
        }
        //end of color changing extra block

        //prints html to user browser passing in different color for font. 
        out.println("<h1 style = 'color:" + colors[i] + ";text-align:center'>" + next + "</h1>");

        break;

    }

    //will jump out and reset ArraylistIndex back to the start. 
    if (nextOneLiner >= oneLiners.size()) {
        nextOneLiner = 0;

        out.println("<h1 style = 'color:" + colors[i] + ";text-align:center'>"
                + "You have reached the end of the One Liners, press 'Next' to continue!!</h1>");
    }

%>

<!--start of html-->

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <%        out.println("<body  style = 'background-color:" + colors[bodyColorIndex] + "'>");
        out.println("<form action = 'OneLiner.jsp'>");
        out.println("<input  type ='submit' name ='Next OneLiner'  value = 'NEXT'/>");
        out.println("</form>");
    %>

</body>
</html>
