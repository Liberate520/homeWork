import java.util.Date;
import java.util.List;

public class Human {

    private String name;
    private String surname;
    private Date dateBirth;

    Gender gender;
    Human father;
    Human mother;

    List<Human> childList;

    public Human(String name, String surname, Date dateBirth, Gender gender,
                 Human father, Human mother, List<Human> childList) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.childList = childList;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Date getDateBirth() {
        return this.dateBirth;
    }

    public List<Human> getChildList() {
        return childList;
    }






}
