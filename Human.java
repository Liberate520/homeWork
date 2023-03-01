import java.sql.Date;
import java.util.List;

/**
 * Human
 */
public class Human {
    private String name;
    private String gender;
    private Date birthDate;
    private Date deadDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String gender, Date birthDate){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDeadDate() {
        return deadDate;
    }

    public void setDeadDate(Date deadDate) {
        this.deadDate = deadDate;
    }
    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void addParrants(Human father, Human mother){
        this.father = father;
        this.mother = mother;
    }

    public void addChild(Human human){
        children.add(human);
    }

    public void addDeadDate(Date deadDate){
        this.deadDate = deadDate;
    }
    
    public void printChildren(){
        System.out.print("Дети " + name + ":");
        if (!children.isEmpty()){
            for (Human child : children) {
                System.out.print(" " + child.getName());
            }
        }
        else{
            System.out.println("У " + name + " детей нет.");
        }
    }

    public void printParrents(){
        System.out.print("Имя отца" + father.getName());
        System.out.print("Имя матери" + mother.getName());
    }
}