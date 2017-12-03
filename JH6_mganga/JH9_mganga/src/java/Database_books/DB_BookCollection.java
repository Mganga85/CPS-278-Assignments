/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_books;

import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


public class DB_BookCollection {
    
    public static String update(Statement statement, HttpServletRequest request)
    {
        String errorMessage="";
        String action = request.getParameter("action");
        if (action != null ) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            String edition = request.getParameter("edition");
            DB_Book book = new DB_Book(title, author, isbn, edition);

            String strIndex;
            int index;

            switch (action) {
                case "Clear List":
                    errorMessage=DB_Book.remove(-1, statement);
                    break;
                case "add":
                    errorMessage = book.insert(statement);
                    break;
                case "remove":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = DB_Book.remove(index, statement);
                    break;
                case "update":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = book.update(index, statement);
                    break;
            }

        }
        
        ArrayList<DB_Book> bookCollection = new ArrayList<>();
        errorMessage += DB_Book.getBooks(statement, bookCollection);
        request.setAttribute("BookCollection", bookCollection);
        
        return errorMessage;
    }

}