/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB_Book {

    private String title;
    private String author;
    private String isbn;
    private String edition;
    int index;

    public DB_Book(String title, String author, String isbn, String edition, int index) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.edition = edition;
        this.index = index;
    }
    public DB_Book(String title, String author, String isbn, String edition) {
        this(title, author, isbn, edition, -1); // index shouldn't be used.
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setIsbn(String is) {
        isbn = is;
    }

    public void setEdition(String e) {
        edition = e;
    }

    public String getEdition() {
        return edition;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    public int getIndex()
    {
        return index;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != getClass()) {
            return false;
        }
        DB_Book bother = (DB_Book) other;
        if (title.equals(bother.title) && author.equals(bother.author)
                && isbn.equals(bother.isbn)) {
            return true;
        } else {
            return false;
        }
    }

    public String update(int index, Statement statement) {
        String sql = "update BookCollection set title=" + q_surround(title)
                + ", author=" + q_surround(author) + ", isbn=" + q_surround(isbn)
                + ", edition=" + q_surround(edition)
                + " where id=" + index;
        return executeUpdate(sql, statement);
    }

    public String insert(Statement statement) {

        // First find out if the book is already in the collection:
        String sql = "select title from BookCollection where title="+ q_surround(title) +
        " AND author=" + q_surround(author) + " AND isbn=" + q_surround(isbn) +
        " AND edition=" + q_surround(edition);
        
        try
        {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())
                return "Book already exists";
        }
        catch (SQLException e)
        {
            return e.toString();
        }
        
        sql = "insert into BookCollection values(" + q_surround(title) + ","
                + q_surround(author) + "," + q_surround(isbn) + "," + q_surround(edition) + ", null)";
        return executeUpdate(sql, statement);
    }

    // Note index =-1 will delete all rows
    public static String remove(int index, Statement statement) {
        String sql = "delete from BookCollection ";
        if (index >= 0)
            sql += " where id=" + index;
        return executeUpdate(sql, statement);
    }

    private static String executeUpdate(String sql, Statement statement) {
        String error = "";
        try {
            System.out.println("sql=" + sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            error = e.toString();
        }
        return error;
    }

    public static String getBooks(Statement statement, ArrayList<DB_Book> books) {
        String error = "";
        try {
            String sql = "select * from BookCollection";
            System.out.println("sql="+sql);
            ResultSet rs = statement.executeQuery(sql);
            books.clear();
            while (rs.next()) {
                String t = rs.getString("title");
                String a = rs.getString("author");
                String i = rs.getString("isbn");
                String e = rs.getString("edition");
                int ind = rs.getInt("id");
                DB_Book bk = new DB_Book(t, a, i, e, ind);
                books.add(bk);
            }
        } catch (SQLException ex) {
            error = ex.toString();
        }
        return error;
    }

    // Surround with single quote
    private String q_surround(String s) {
        return "\'" + s + "\'";
    }
}
