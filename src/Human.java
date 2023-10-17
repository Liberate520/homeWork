import java.time.LocalDate;
import java.util.List;

public class Human {
    String firstName;
    String lastName;
    LocalDate born;
    LocalDate died;
    Human mother;
    Human father;
    List<Human> children;

//    public Human(String firstName, String lastName, LocalDate born, LocalDate died, Human mother, Human father, List<Human> children) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.born = born;
//        this.died = died;
//        this.mother = mother;
//        this.father = father;
//        this.children = children;
//    }

    public Human(String firstName, String lastName, LocalDate born, LocalDate died, List<Human> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
        this.died = died;
        this.children = children;
    }

    public Human(String firstName, String lastName, LocalDate born) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
    }

    public Human(String firstName, String lastName, LocalDate born, LocalDate died) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
        this.died = died;
    }

    //    @Override
//    public String toString() {
//        return "First name: " + firstName + ", Last name: " + lastName + ", Date of Birth: " + born + ", Date of death: " + died + ", Mother: " + mother.getFirstName() + " " + mother.getLastName() + ", Father" + father.getFirstName() + " " + father.getLastName();
//    }

    @Override
    public String toString() {
        return "First name: " + firstName + ", Last name: " + lastName + ", Date of Birth: " + born + ", Date of death: " + died + ".";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public LocalDate getDied() {
        return died;
    }

    public void setDied(LocalDate died) {
        this.died = died;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

}
