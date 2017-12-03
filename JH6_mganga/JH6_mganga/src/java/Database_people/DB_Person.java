/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_people;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB_Person {

    private String name;
    private String eyeColor;
    private String hairColor;
    private String height;
    private String weight;
    int index;

    public DB_Person(String name, String eyeColor, String hairColor, String height,String weight, int index) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
        this.index = index;
    }
    public DB_Person(String name, String eyeColor, String hairColor, String height,String weight) {
        this(name, eyeColor, hairColor, height,weight, -1); // index shouldn't be used.
    }

    public void setName(String n) {
        name = n;
    }

    public void setEyeColor(String ec) {
        eyeColor = ec;
    }

    public void setHairColor(String hc) {
       hairColor = hc;
    }

    public void setHeight(String h) {
        height = h;
    }
    
     public void setWeight(String w) {
       weight = w;
    }
     
   

    public String getName() {
        return name;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getHeight() {
        return height;
    }
    
    public String getWeight(){
        return weight;
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
        DB_Person pother = (DB_Person) other;
        if (name.equals(pother.name) && eyeColor.equals(pother.eyeColor)
       && height.equals(pother.height) && hairColor.equals(pother.hairColor) && weight.equals(pother.weight)) {
            return true;
        } else {
            return false;
        }
    }

    public String update(int index, Statement statement) {
        String sql = "update PersonCollection set name=" + q_surround(name)
                + ", eyeColor=" + q_surround(eyeColor) + ", hairColor=" + q_surround(hairColor)
                + ", height=" + q_surround(height) + ", weight=" + q_surround(weight)
                + " where id=" + index;
        return executeUpdate(sql, statement);
    }

    public String insert(Statement statement) {

        // First find out if the book is already in the collection:
        String sql = "select name from PersonCollection where name="+ q_surround(name) +
        " AND eyeColor=" + q_surround(eyeColor) + " AND hairColor=" + q_surround(hairColor) +
        " AND height=" + q_surround(height) + " AND weight=" + q_surround(weight);
        
        try
        {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())
                return "Perosn already exists";
        }
        catch (SQLException e)
        {
            return e.toString();
        }
        
        sql = "insert into PersonCollection values(" + q_surround(name) + ","
                + q_surround(eyeColor) + "," + q_surround(hairColor) + "," + q_surround(height)+ "," + q_surround(weight) + ", null)";
        return executeUpdate(sql, statement);
    }

    // Note index =-1 will delete all rows
    public static String remove(int index, Statement statement) {
        String sql = "delete from PersonCollection ";
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

    public static String getPeople(Statement statement, ArrayList<DB_Person> people) {
        String error = "";
        try {
            String sql = "select * from PersonCollection";
            System.out.println("sql="+sql);
            ResultSet rs = statement.executeQuery(sql);
            people.clear();
            while (rs.next()) {
                String n = rs.getString("name");
                String e = rs.getString("eyeColor");
                String h = rs.getString("hairColor");
                String hgt = rs.getString("height");
               String wgt = rs.getString("weight");

                int ind = rs.getInt("id");
                DB_Person ps = new DB_Person(n, e, h, hgt,wgt, ind);
               people.add(ps);
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