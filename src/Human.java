import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Human {
    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Set<Human> children;

    public Human(String firstName, String lastName, Sex sex, LocalDate birthDate, LocalDate deathDate, Human mother,
                 Human father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new HashSet<>();
    }

    public Human(String firstName, String lastName, Sex sex, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, sex, birthDate, deathDate, null, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Set<Human> getChildren() {
        return children;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(Set<Human> children) {
        this.children = children;
    }

    public String getAge(){
        return "продолжительность жизни: " + Period.between(birthDate, deathDate).getYears() + " years";
    }

    public void addChild(Human human){
        children.add(human);
    }

    public String getMotherInfo(){
        String str = "мать: ";
        if (mother != null){
            str += mother.getFirstName() + " " + mother.getLastName();
        }else {
            str += "unknown";
        }
        return str;
    }

    public String getFatherInfo(){
        String str = "отец: ";
        if (father != null){
            str += father.getFirstName() + " " + father.getLastName();
        }else {
            str += "unknown";
        }
        return str;
    }

    public String getChildrenInfo(){
        String str = "дети: ";
        if (children.size() != 0){
            for (Human child: children) {
                str += child.getFirstName() + " " + child.getLastName() + ", ";
            }
        }else {
            str += "unknown";
        }
        return str.replaceAll(", $", "");
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " " + lastName + ", пол: " + sex + ", дата рождения: " + birthDate +
                ", дата смерти: " + deathDate + ", " + getAge() + ", " + getMotherInfo() + ", " + getFatherInfo() +
                ", " + getChildrenInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName) && sex == human.sex && Objects.equals(birthDate, human.birthDate) && Objects.equals(deathDate, human.deathDate) && Objects.equals(mother, human.mother) && Objects.equals(father, human.father) && Objects.equals(children, human.children);
    }
}
