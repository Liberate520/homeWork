import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private String bornDate;
    private String deathDate;
    private Gender gender;
    private List<Human> children;
    private List<Human> parents;

    public Human(String firstName, String lastName, String bornDate, String deathDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Human(String firstName, String lastName, String bornDate, Gender gender) {
        this(firstName, lastName, bornDate, null, gender);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    public void removeParent(Human parent) {
        parents.remove(parent);
    }

    public List<Human> getChildren() {
        return children;
    }
    


    public List<Human> getParents() {
        return parents;
    }

    public void printChildren() {
        if (!children.isEmpty()) {
            for (Human child : children) {
                System.out.println(child);
            }
        } else {
            System.out.println("Отсутствуют");
        }
    }

    public void printParents() {
        if (!parents.isEmpty()) {
            for (Human parent : parents) {
                System.out.println(parent);
            }
        } else {
            System.out.println("Отсутствуют");
        }
    }

    @Override
    public String toString() {
        if (deathDate != null) {
            return "Фамилия:" + firstName + ", Имя: " + lastName + ", ДР: " + bornDate + ", ДС: " + deathDate + ", Пол: " + gender;
        } else {
            return "Фамилия:" + firstName + ", Имя: " + lastName + ", ДР: " + bornDate + ", Пол: " + gender;
        }
    }
}
