package jdbc1;

import java.net.URL;
import java.sql.*;

public class CreateStates {

public static void main(String args[]) {

    Connection con = MyConnection.getConnection(args);
    String createString;
    String createString2;
    String query = "select * from States";
    createString2 = "drop table if exists States;";

    createString = "create table States "
          
            + "(StateID int primary key,"
            + "StateName varchar (40), "
            + "Region varchar(20) , "
            + "LargestCity varchar(40) , "
            + "Capital varchar(20) ,"
            + "Population int "
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


        stmt.executeUpdate("insert into States " + "values(1,'Michigan', 'Midwest', 'Detroit','Lansing', 9928000 )");
        stmt.executeUpdate("insert into States " + "values(2,'New York', 'East', 'New York City','Albany', 19750000 )");
        stmt.executeUpdate("insert into States " + "values(3,'Texas', 'South Central', 'Houston','Austin', 27760000 )");
        stmt.executeUpdate("insert into States " + "values(4,'Wisconsin', 'Midwest', 'Milwaukee','Madison', 5779000 )");



       ResultSet rs = stmt.executeQuery(query);
      System.out.println("State: StateName, LargestCity, Capital, Population");

       while (rs.next()) {
           String stateName  = rs.getString("stateName");
           String largestCity  = rs.getString("LargestCity");
           String capital  = rs.getString("Capital");
           int population = rs.getInt("Population");
           System.out.println(stateName + "   " + largestCity + "   " + capital + "  " + population );
       }

        stmt.close();

        con.close();

    } catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
    }

}
}
