import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable{
    private String firstName;
    private String lastName;
    private Gender gender;
    private String dateOfBirth;
    private String dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> childrenList;

    /**
     * @param firstName    - Имя
     * @param lastName     - Фамилия
     * @param gender       - Пол
     * @param dateOfBirth  - Дата рождения
     * @param dateOfDeath  - Дата смерти ( не обязательно )
     * @param mother       - Мать (не обязательно)
     * @param father       - Отец (не обязательно)
     * @param childrenList Дети ( не обязательно)
     */
    public Human(String firstName, String lastName, Gender gender,
                 String dateOfBirth, String dateOfDeath, Human mother,
                 Human father, List<Human> childrenList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.childrenList = childrenList;
    }

    /**
     * Конструктор ,который позволят не заполнять неочевидные поля
     */
    public Human(String firstName, String lastName, Gender gender, String dateOfBirth) {
        this(firstName, lastName, gender, dateOfBirth, null, null, null, null);
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getMother() {
        return mother;
    }

    /**При изменении  поля "мать" , у обьекта "Мать" добавляется "ребенок"*/
    public void setMother(Human newMother) {
        this.mother = newMother;
        newMother.childrenList = new ArrayList<>();
        newMother.childrenList.add(this);

    }

    public Human getFather() {
        return father;
    }

    /**При изменении  поля "отец" , у обьекта "Отец" добавляется "ребенок"*/
    public void setFather(Human NewFather) {
        this.mother = NewFather;
        NewFather.childrenList = new ArrayList<>();
        NewFather.childrenList.add(this);
    }

    public List<Human> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Human> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.firstName == firstName || this.lastName == lastName || this.dateOfBirth == dateOfBirth) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Человек{" +
                "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", Пол=" + gender +
                ", Дата рождения=" + dateOfBirth +
                ", Дата смерти=" + dateOfDeath +
                ", Мать=" + mother +
                ", Отец=" + father +
                ", Дети=" + childrenList +
                '}';
    }

    public String getFullName() {
        return this.getLastName() + " " + this.getFirstName();
    }

    /**
     * Выдает информацию о человеке
     */
    public void getInfo() {
        System.out.println("Имя------------ " + firstName + "\nФамилия-------- " + lastName + "\nДата рожедния-- " + dateOfBirth);
        if (dateOfDeath != null) System.out.println("Дата смерти---- " + dateOfDeath);
        if (mother != null) System.out.println("Мать----------- " + this.mother.getFullName());
        if (father != null) System.out.println("Отец----------- " + this.father.getFullName());
        if (childrenList != null) {
            System.out.println("Дети:");
            for (Human e : childrenList) {
                System.out.println("     " + e.getFullName());
            }
        }
    }

}

