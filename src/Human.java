import java.util.ArrayList;
import java.util.List;


public class Human {

    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private String name;
    private String surname;
    private String dateOfBirth;

    public Human(String name, String surname, String dateOfBirth, Gender gender, Human father, Human mother,
            List<Human> children) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }
    
    public Human(String name, String surname, String dateOfBirth, Gender gender, Human father, Human mother) {
        this(name, surname, dateOfBirth, gender, father, mother, null);
    }

    public Human(String name, String surname, String dateOfBirth, Gender gender, List<Human> children) {
        this(name, surname, dateOfBirth, gender, null, null, children);
    }

    public Human(String name, String surname, String dateOfBirth, Gender gender) {
        this(name, surname, dateOfBirth, gender, null, null, null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getDateOfBirth() {
        
        return dateOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }


    @Override
    public String toString() {
        return name + " " + surname + " Дата рождения: " + dateOfBirth + " Пол: " + gender + " Отец: " + father + " Мать: " + mother + " Дети: " + children;
    }
    
    public void addChildren(Human person) {
        if (this.children == null)
            this.children = new ArrayList<>();
        this.children.add(person);
    }
    

}
