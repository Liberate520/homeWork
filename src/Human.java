import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private Date dateOfBirth = new Date();
    private Date dateOfDeath = new Date();
    private Human mother;
    private Human father;
    private String gender;
    private List<Human> children = new ArrayList<Human>();

    public Human(String name, String surname,
                 Date dateOfBirth, Date dateOfDead, Human mother,
                 Human father,String gender, List children){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDead;
        this.mother = mother;
        this.father = father;
        this.gender = gender;
        this.children = children;
    }

    public void setMother(Human human){
        this.mother = human;
        human.setChildren(this);

    }
    public void setFather(Human human){
        this.father = human;
        human.setChildren(this);
    }
    public void setChildren(Human human){
        this.children.add(human);
        if (gender.equals("female")){
            human.setMother(this);
        }
        if (gender.equals("male")){
            human.setFather(this);
        }

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getGender() {
        return gender;
    }


}
