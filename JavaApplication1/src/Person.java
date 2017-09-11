
public class Person {
    
    String name;
    String race;
    
    public Person()
    {
        name = "";
        race = "human";
    }
    
    public Person(String name, String race)
    {
        this.name = name;
        this.race = race;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name)
    {
        this.name = name;
    }
    
}
