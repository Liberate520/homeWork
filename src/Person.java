import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private Sex sex;
    private boolean alive;
    private int age;
    private Person mother;
    private Person father;
    private Person spouse;
    private List<Person> children;

    public Person(String firstName, String lastName, Sex sex, boolean alive, int age, Person mother, Person father, Person spouse, List<Person> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.alive = alive;
        this.age = age;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.children = children;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(Person children) {
        this.children.add(children);
        if (spouse != null) {
            getSpouse().setChildren(children);
        }
    }
}