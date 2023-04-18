import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private List<Human> brothers;
    private List<Human> sisters;
    private FamilyTree familyTree;

    public Human(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Human(String firstName, String lastName, LocalDate birthDate, Gender gender,
            Human mother, Human father, List<Human> children, List<Human> brothers, List<Human> sisters,
            FamilyTree familyTree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.brothers = brothers;
        this.sisters = sisters;
        this.familyTree = familyTree;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public List<Human> getBrothers() {
        return brothers;
    }

    public void setBrothers(List<Human> brothers) {
        this.brothers = brothers;
    }

    public List<Human> getSisters() {
        return sisters;
    }

    public void setSisters(List<Human> sisters) {
        this.sisters = sisters;
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName)
                && Objects.equals(birthDate, human.birthDate) && gender == human.gender
                && Objects.equals(mother, human.mother) && Objects.equals(father, human.father)
                && Objects.equals(children, human.children) && Objects.equals(brothers, human.brothers)
                && Objects.equals(sisters, human.sisters) && Objects.equals(familyTree, human.familyTree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, gender, mother, father, children, brothers, sisters,
                familyTree);
    }

    @Override
    public String toString() {
        String genderString = gender == Gender.MALE ? "Мужчина" : "Женщина";
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName).append("\n");
        sb.append("Дата рождения: ").append(birthDate).append("\n");
        sb.append("Пол: ").append(genderString).append("\n");
        if (mother != null) {
            sb.append("Мать: ").append(mother.getFirstName()).append(" ").append(mother.getLastName()).append("\n");
        }
        if (father != null) {
            sb.append("Отец: ").append(father.getFirstName()).append(" ").append(father.getLastName()).append("\n");
        }
        if (brothers != null && !brothers.isEmpty()) {
            sb.append("Братья: ");
            for (Human brother : brothers) {
                sb.append(brother.getFirstName()).append(" ").append(brother.getLastName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append("\n");
        }
        if (sisters != null && !sisters.isEmpty()) {
            sb.append("Сестры: ");
            for (Human sister : sisters) {
                sb.append(sister.getFirstName()).append(" ").append(sister.getLastName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append("\n");
        }
        if (children != null && !children.isEmpty()) {
            sb.append("Дети: ");
            for (Human child : children) {
                sb.append(child.getFirstName()).append(" ").append(child.getLastName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append("\n");
        }
        return sb.toString();
    }
    
}