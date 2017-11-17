package jdbc1;

import java.net.URL;
import java.sql.*;

public class CreateCities {

    public static void main(String args[]) {

        Connection con = MyConnection.getConnection(args);
        String createString;
        String createString2;
        String query = "select * from Cities";
        createString2 = "drop table if exists Cities;";

        createString = "create table Cities "
                + "(cityID int primary key,"
                + "stateID int ,"
                + "CityName varchar (40), "
                + "StateName varchar(20), "
                + "Population int"
                + ");";

        Statement stmt;

        if (con == null) {
            System.out.println("Unable to create connection");
            return;
        }

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString2);// gets rid of table if exists already
            stmt.executeUpdate(createString);
            
            
            stmt.executeUpdate("insert into Cities " + "values(1,1,'Detroit', 'Michigan', 672795 )");
            stmt.executeUpdate("insert into Cities " + "values(2,2,'New York City','New York', 8538000)");
            stmt.executeUpdate("insert into Cities " + "values(3,3,'Houston','Texas',2300000 )");
            stmt.executeUpdate("insert into Cities " + "values(4,4,'Milwaukee','Wisconsin', 595047 )");

            
            
           ResultSet rs = stmt.executeQuery(query);
          System.out.println("Cities: StateName, LargestCity, Capital, Population");
          
           while (rs.next()) {
               String cityName  = rs.getString("CityName");
               String stateName  = rs.getString("StateName");
               int population = rs.getInt("Population");
               System.out.println(cityName + "   " + stateName + "   " + population );
           }
   
            stmt.close();

            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }
}
