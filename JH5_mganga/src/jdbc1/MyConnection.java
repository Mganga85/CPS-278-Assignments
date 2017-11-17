package jdbc1;

import java.net.URL;  
import java.sql.*;  
       
public class MyConnection {  
  
   public static Connection getConnection(String args[]) {  
         
       Connection con=null; 
       String urlStr=null;
   
       if (args.length < 2 )   
       {   
           //System.out.println("You need to enter:");   
           //System.out.println("         arg[0] = Userid, arg[1] = password");   
           // con;   
          args = new String[2];
          args[0] = "mganga";
          args[1] = "jG8Aw3Zf66BW";
       }  
   
       try {     
            //Load the Driver Class Now       
             Class.forName("com.mysql.jdbc.Driver").newInstance();   
              
            urlStr =   "jdbc:mysql://russet.wccnet.edu/" + args[0] +
                  "?user="+args[0]+ "&password="+args[1];
            System.out.println("Connecting to : " + urlStr);
            con = DriverManager.getConnection (urlStr);    
      
       } 
       catch(SQLException ex) {   
           System.err.println("SQLException("+urlStr+"): " + ex);   
       }  
       catch (Exception ex)
        {
            System.err.println("Exception("+urlStr+"): " + ex);    
        } 
 
       return con;  
   }  
}  
  
