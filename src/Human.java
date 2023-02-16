import java.util.List;

public class Human {
    private String firstname;
    //    private String lastname;
    private Human mother;
    private Human father;
    private Sex sex;
    private List<Human> children;

    public Human(String firstname, Sex sex) {
//        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Human(String firstname, Sex sex, Human father, Human mother) {
//        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.children = null;
    }

    public String toString() {
        return " -> " +
//                lastname + " " +
                firstname + ". " +
                "Родители: " + mother + ", " + father + ". " +
                "Дети: " + children + ".";

    }

    public String getFather(String name) {
        return Human.this.getFirstname(name);
    }

    public String getFirstname(String name) {
        return firstname;
    }
}