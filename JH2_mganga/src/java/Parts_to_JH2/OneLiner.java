/*
 * @ Author: Matthew Ganga
   CPS: 278
   Homework# JH2
   Onliner Program will print one line at a time from an array created from a file
   located in the WEB-INF directory. 
 */
package JH2_Servlets;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneLiner extends HttpServlet {

    private String filename = ""; // will bbe used as variable for xml filename value. 
    private Scanner scanFile;     // will be used to read in file. 
    private int nextOneLiner = 0; // this will start back at 0, after it is greater than array.size();
    private String next = " ";    // next String to print, controlled in nextLine Method   

    ArrayList<String> oneLiners = new <String>ArrayList();

    @Override
    public void init() throws ServletException {
        ServletConfig sc = getServletConfig();
        filename = sc.getInitParameter("inputfilename");

    }

    // will bbe called everytime
    public String nextLine(int index) {
        nextOneLiner += 1;
        while (nextOneLiner < oneLiners.size()) {
            next = oneLiners.get(nextOneLiner);
            break;
        }
        return next;
     
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //will find path for our file to read from
            ServletContext sc = getServletContext();
            String path = sc.getRealPath("/WEB-INF");
            path += System.getProperty("file.separator") + filename;
           
            //creates string path for console verification. 
            System.out.println("path=" + path);

            // this will pass the file path to the scanner to read.
            try{
            scanFile = new Scanner(new File(path));
            }catch(Exception e)
            {
                System.out.println("File could not be found");
            }

            // will try and open the file. 
            while (scanFile.hasNext()) {
                //will create array of one liners
                while (scanFile.hasNext()) {
                    String a = scanFile.nextLine();
                    oneLiners.add(a);
                }
                scanFile.close();

                // when this next button is pressed, I will begin to run through the created array to 
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet OneLiner</title>");
                out.println("</head>");
                out.println("<body style = 'background-color:lightblue; color:darkgreen'>");
                out.println("<form action = \"OneLiner\"/>");
                
                //next Line method will be called on every button press or refresh
                out.println("<h1>" + nextLine(nextOneLiner) + "</h1>");
                
                
                out.println("<input type = \"submit\" name = \"nextButton\" value =\"Next\"/> ");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

            }
                 

            /* TODO output your page here. You may use following sample code. */
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
