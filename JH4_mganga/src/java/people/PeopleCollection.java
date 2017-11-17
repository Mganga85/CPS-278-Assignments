package people;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;


public class PeopleCollection {

    private ArrayList<Person> pArray = new ArrayList<Person>();
    String errorMessage="";

    public int size() {
        return pArray.size();
    }

    public Person getPerson(int index) {
        return pArray.get(index);
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }

    public static PeopleCollection update(PageContext pageContext) {
        HttpSession session = pageContext.getSession();
        PeopleCollection pc = (PeopleCollection) session.getAttribute("PeopleCollection");
        if (pc == null) 
        {
            pc = new PeopleCollection(); // Default Constructor provided from compiler
            session.setAttribute("PeopleCollection", pc);
        }

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String action = request.getParameter("action");
        if (action != null) 
        {
            String name = request.getParameter("name");
            String eyeColor = request.getParameter("eyeColor");
            String hairColor = request.getParameter("hairColor");
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            
            Person person = new Person(name, eyeColor,hairColor,height,weight);
            
            
            if("CLEAR ALL".equals(action))
            {
               pc.pArray.clear();
            }
          
            
            
            if ("add".equals(action)) {
                boolean found = false;
                // Check for uniqueness
                for (int i = 0; i < pc.pArray.size(); i++) {
                    if (person.equals(pc.pArray.get(i))) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    pc.pArray.add(person);
                  pc.errorMessage="";
                }
                else
                    pc.errorMessage="Person already exists";
            }
           else if ("remove".equals(action)) {
                for (int i = 0; i < pc.pArray.size(); i++) {
                    if (person.equals(pc.pArray.get(i))) {
                        pc.pArray.remove(i);
                    }
                    
                }
            }else if("update".equals(action)){
                String strIndex = request.getParameter("index");
                int index = Integer.parseInt(strIndex);
                
               Person p = pc.pArray.get(index);
               p.setName(name);
               p.setEyeColor(eyeColor);
               p.setHairColor(hairColor);
               p.setHeight(height);
               p.setWeight(weight);
               
               
               
                
            }
        }

        return pc;
    }
}
