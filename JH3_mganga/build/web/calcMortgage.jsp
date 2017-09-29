
<%@page import="java.text.NumberFormat"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="static java.lang.System.out"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import=" static java.util.Collections.enumeration"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>



<%
    
   
    double interestRate = 0.0;
    double payment = 0;
    double principal = 0;
    double newPrincipal =0;
    double monthsInterest = 0.0;
    int years = 0;
    int months =0;
    double totalInterest = 0;
    
    DecimalFormat df = new DecimalFormat("#.00");
    NumberFormat money = NumberFormat.getCurrencyInstance();
    NumberFormat percent = NumberFormat.getPercentInstance();
    

    //handles interest rate converts string to double
    String rate = request.getParameter("rateString");
    interestRate = Double.parseDouble(rate);
   

    //handles starting mortgage principal
    String principalString = request.getParameter("principalString");
    principal = Double.parseDouble(principalString);
    
        

    String paymentString = request.getParameter("paymentString");
    payment = Double.parseDouble(paymentString);

    String yearsString = request.getParameter("yearsString");
    years = Integer.parseInt(yearsString);
    
   

            out.println("</table>");

            
%>


<html>
    <title>Calculate JSP</title>
    <head>
      <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="formStyle.css"> <!--will use CSS style sheet called form Style. -->
    </head>
    
    <body class = "output">
        <hr>
        <div class = "one">
        <h1 class = "main">Data You have Submitted To Us:</h1>  
        <h3>Starting Mortgage Amount:&nbsp;<%=money.format(principal)%></h3>
        <h3>Annual Interest Rate:&nbsp;<%=percent.format(interestRate/100)%></h3>
        <h3>Monthly Payment Amount:&nbsp;<%=money.format(payment)%></h3>
        <h3>Length of Mortgage(in years):&nbsp;<%=years%></h3>
        
     </div >  
     <hr>
        <h1 class = "main">Table of Calculations<h1>
        
        <table class = "output">
           <th>Month of Mortgage</th><th>Principal</th><th>Interest</th></th>
            <%
           //will calculate new Prinicpal, interest and number of months.
             int m = 0;
             months = 12 * years;
          
           
         while (months > m) {
                m++;
                monthsInterest = (principal * interestRate) / (12 * 100);
                newPrincipal = principal + monthsInterest - payment;
                totalInterest += monthsInterest;
                principal = newPrincipal;
                
                out.println("<tr><td>" + m + "</td><td>" + money.format(newPrincipal) + "</td>" + "<td>" + money.format(monthsInterest) + "</td>");
                
             if(m==12*years&&newPrincipal>payment)
               {
                 out.println("<h3 style = 'color:red; background-color:white'>Error: You must make a higher monthly payment to pay off in time</h3>");
               }              
             if (newPrincipal < payment) {

                    break;
              
            }
            }
         out.println("<tr><td  colspan =' 2'></td><td></td></tr>");
             out.println("<tr><td  class = 'total' colspan =' 2'>TOTAL INTEREST PAID </td><td class = 'total'>" + money.format(totalInterest) + "</td></tr>");
            %>
            
           
        </table>
        <form>
         <input type="button" value="Make Edits" onclick="history.back()">
       </input>
</form>
        
        
        
       
        
    </body>
    
    
    
    
    
</html>

