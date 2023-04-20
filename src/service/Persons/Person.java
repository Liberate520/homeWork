package service.Persons;




import java.util.ArrayList;


public class Person implements InterfacePerson{
    private String name;
    private int date;
    private Gender gender;
    private Person father;
    private Person mother;
    private ArrayList<Person> children = new ArrayList<>();

    public Person(String name, Gender gender, int date, Person father, Person mother, ArrayList<Person> children) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.father = father;
        this.mother = mother;
        this.children=children;
    }

    public Person()
    {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Person getFather() {
        return father;
    }
    public void setFather(Person father) {
        this.father = father;
    }
    public Person getMother() {
        return mother;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }
    public ArrayList<Person> getChildren() {
        return children;
    }
    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }
    public void addChildren(Person person) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(person);
    }
}
