import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
public class Others implements Serializable, Node

{
    private int id;
    private String Name;
    private String Occupation;


    public Others(int id, String Name, String Occupation)
    {
        this.id = id;
        this.Name = Name;
        this.Occupation = Occupation;
       
    }    

    public Others(int id, String Name)
    {
        this(id, Name, null);
        
    }

    public Others(int id)
    {
        this(id, null, null);     
    }

    public Others()
    {
        this(0,  null, null);
    }
    
    


   
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    
    

    
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }
    
    
    
    

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(id).append(", имя: ").append(Name).append("\n").append("   должность:  ").append(Occupation).append("\n");

        return sb.toString();
    }
}

