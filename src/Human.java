import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Human {
    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath){
        this.id = idCounter++;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }
    public Human(String name, Gender gender, LocalDate dateOfBirth){
        this.id = idCounter++;;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    private static int idCounter = 0;
    public final int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath = LocalDate.MIN;
    private List<Human> parentList = new ArrayList<>();
    private List<Human> childrenList = new ArrayList<>();
    public List<Human> GetParentsList(){
        return parentList;
    };
    public int getId(){
        return this.id;
    }
    public List<Human> GetChildrensList(){
        return childrenList;
    };
    public void AddParent(Human e){
        parentList.add(e);
    }
    public void AddChildren(Human e){
        childrenList.add(e);
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
