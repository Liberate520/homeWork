import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String name;
    private String sex;
    private Date DateOfBirth;
    private Date DateOfDeath;


    public Person (String name, String sex, Date DateOfBirth, Date DateOfDeath){
        this.name = name;
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.DateOfDeath = DateOfDeath;
    }
    public Person (){
        this("Unkown", "Unkown", null, null);
    }    
    public Person (String name, String sex, Date DateOfBirth){
        this(name, sex, DateOfBirth, null);
    }

    public String toString(){
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String rez="Person "+ "name ='" + name + "' пол ='" + sex +  "'";
        // sdf.parse(DateOfBirth.toString());
        if(DateOfBirth!=null) rez=rez+" Дата рождения - " + DateOfBirth.toString() ;
        if(DateOfDeath!=null) rez=rez+" Дата смерти - " + DateOfDeath.toString() ;
        return rez;
    }
}