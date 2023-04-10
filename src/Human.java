import java.util.HashSet;
import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private String firstName, lastName, sex;
    private Human parent1, parent2;
    private HashSet<Human> childrens;
    private LocalDate birthDate;

    public Human(String firstName, String lastName, LocalDate birthDate, String sex,
                Human parent1, Human parent2, HashSet<Human> childrens) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.childrens = new HashSet<Human>();
    }

    public Human(String firstName, String lastName, LocalDate birthDate, String sex, Human parent1, Human parent2) {
        this(firstName, lastName, birthDate, sex, parent1, parent2, new HashSet<Human>());
    }

    public Human(String firstName, String secondName, LocalDate birthDate, String sex) {
        this(firstName, secondName, birthDate, sex, null, null, new HashSet<Human>());
    }

    public Human(String firstName, String secondName, LocalDate birthDate, String sex, Human parent) {
        this(firstName, firstName, birthDate, sex, parent, parent, new HashSet<Human>());
    }

    public Human(String firstName, String secondName, LocalDate birthDate, String sex, HashSet<Human> childrens) {
        this(firstName, firstName, birthDate, sex, null, null, childrens);
    }

    

    public void setChildrens(HashSet<Human> childrens) {
        this.childrens = childrens;
    }

    public void addChildren(Human children) {
        this.childrens.add(children);
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public Human getParent1() {
        return parent1;
    }
    public Human getParent2() {
        return parent2;
    }

    public Human[] getParents() {
        Human[] result = new Human[]{this.parent1, this.parent2};
        return result;
    }

    public HashSet<Human> getChildrens() {
        return this.childrens;
    }

    public String stringChildren() {
        StringBuilder result = new StringBuilder();
        for (Human human : this.childrens) {
            result.append(human.toString() + ", ");
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length() - 1);
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return (this.firstName + " " + this.lastName + " (" + this.birthDate.getDayOfMonth() + 
                    "." + this.birthDate.getMonthValue() + "." + this.birthDate.getYear() + ")");
    }

    @Override
    public int hashCode() {
        int result = (firstName != null ? firstName.hashCode() : 0) * (lastName != null ? lastName.hashCode() : 0) *
                    (birthDate != null ? birthDate.hashCode() : 0) * (sex != null ? sex.hashCode() : 0);

        return result + 99999999;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        Human that = (Human) obj;
        if (firstName != that.firstName ||
            lastName != that.lastName ||
            birthDate != that.birthDate ||
            sex != that.sex) return false;

        return true;
    }

}
