package people;


public class Person {
    private String name;
    private String eyeColor;
    private String hairColor;
    private String height;
    private String weight;
    
    public Person(String name, String eyeColor, String hairColor, String height,String weight)
    {
       this.name= name;
       this.eyeColor = eyeColor;
       this.hairColor = hairColor;
       this.height = height;
       this.weight = weight;
    }
    
    public void setName(String n)
    {
        this.name = n;
        
    }
     public void setEyeColor(String ec)
    {
        this.eyeColor=ec;
        
    }
     public void setHairColor(String hc)
     {
         this.hairColor = hc;
     }
     
     public void setHeight(String h)
     {
         this.height= h;
     }
     
      public void setWeight(String w)
     {
         this.weight= w;
     }
    
    
    public String getName()
    {
        return name;
    }
    public String getEyeColor()
    {
        return eyeColor;
    }
    public String getHairColor()
    {
        return hairColor;
    }
    public String getHeight()
    {
        return height;
    }
     public String getWeight()
    {
        return weight;
    }
    public boolean equals(Object other)
    {
        if (other == null) return false;
        if (other.getClass() != getClass())
            return false;
        
        Person pother = (Person)other;
        if (name.equals(pother.name) && eyeColor.equals(pother.eyeColor) && 
                hairColor.equals(pother.hairColor)&&height.equals(pother.height)&&weight.equals(pother.weight))
            return true;
        else 
            return false;
    }
    
}