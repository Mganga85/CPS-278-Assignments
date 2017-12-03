
package Database_people;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


public class DB_PersonCollection {
    
    public static String update(Statement statement, HttpServletRequest request)
    {
        String errorMessage="";
        String action = request.getParameter("action");
        if (action != null ) {
            String name = request.getParameter("name");
            String eyeColor = request.getParameter("eyeColor");
            String hairColor = request.getParameter("hairColor");
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            DB_Person person = new DB_Person(name, eyeColor,hairColor, height,weight);

            String strIndex;
            int index;

            switch (action) {
                case "Clear List":
                    errorMessage=DB_Person.remove(-1, statement);
                    break;
                case "add":
                    errorMessage = person.insert(statement);
                    break;
                case "remove":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = DB_Person.remove(index, statement);
                    break;
                case "update":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = person.update(index, statement);
                    break;
            }

        }
        
        ArrayList<DB_Person> personCollection = new ArrayList<>();
        errorMessage += DB_Person.getPeople(statement, personCollection);
        request.setAttribute("PersonCollection", personCollection);
        
        return errorMessage;
    }

}