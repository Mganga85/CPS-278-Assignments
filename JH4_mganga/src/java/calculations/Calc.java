/*
 JH4 Version
 */
package calculations;
import java.io.*;
import java.util.*;

/**
 *
 * @author Matt
 */
public class Calc {
    
   String oneLine=" ";
   Scanner readFile = null;
   
   
  ArrayList <String> oneLiners = new <String> ArrayList();  

   // will attempt to open file, specified path is above. path wil
   public ArrayList <String> getArray(String file)
   {
       StringBuilder stringBuilder = new StringBuilder();
       
        try  {
        readFile = new Scanner(new File(file));
    } catch (IOException e) {
        System.out.println("Could not locate file specified....." + e);
        
    }

    // if file open is a success, contents of file will be stored in ArrayList named oneLiners.
    while (readFile.hasNext()) {
        oneLine = readFile.nextLine();
        oneLiners.add(oneLine);
       
    } 
    readFile.close();
    return oneLiners;
   }
   
 // this method will create an array of colors to use.  
 public String[] getColorsArray(){
     String[] colors = new String[10];
    colors[0] = "green";
    colors[1] = "blue";
    colors[2] = "gold";
    colors[3] = "silver";
    colors[4] = "teal";
    colors[5] = "pink";
    colors[6] = "lightblue";
    colors[7] = "magenta";
    colors[8] = "yellow";
    colors[9] = "black";
    return colors;
 }
   

    
}

