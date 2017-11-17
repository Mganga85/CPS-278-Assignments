package jdbc1;

import java.net.URL;
import java.sql.*;

public class DeleteUpdate {

    public static void main(String args[]) {

        Connection con = MyConnection.getConnection(args);
        String createString;
        String createString2;
        String query = "select * from States join Cities on States.stateId = Cities.stateID; ";
        String delQuery = "Delete from Cities where cityID = 1;";
        String replaceQuery = "Update Cities set Population = 300 where cityID =2";

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
            System.out.println("Cities: CityName, Population, stateName, Region");

            while (rs.next()) {
                String cityName = rs.getString("CityName");
                int population = rs.getInt("Cities.Population");//  there are two Population feilds in both tables
                String stateName = rs.getString("StateName");
                String region = rs.getString("Region");

                System.out.println("        " + cityName + "   " + population + "   " + stateName + "  " + region);
            }

            stmt.execute(delQuery);// deletes first city in table;
            stmt.execute(replaceQuery);
            ResultSet rs2 = stmt.executeQuery(query);// creates a new Result Set to print out values.

            System.out.println("----------------------After Edits-----------------");

            System.out.println("Cities: CityName, Population, stateName, Region");

            while (rs2.next()) {
                String cityName = rs2.getString("Cities.CityName");
                int population = rs2.getInt("Cities.Population");
                String stateName = rs2.getString("StateName");
                String region = rs2.getString("Region");

                System.out.println("        " + cityName + "   " + population + "   " + stateName + "  " + region);
            }

            stmt.close();

            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }
}
