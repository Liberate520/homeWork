import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person> {
    private List<Person> children;
    private String name;
    private int age;
    private String sex;
    private Person mother;
    private Person father;


    public Person(String name, int age, String sex, Person mother, Person father) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        if (this.mother != null) addChild(mother);
        if (this.father != null) addChild(father);
    }

    public Person(String name, int age, String sex, Person mother) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mother = mother;
        this.father = null;
        this.children = new ArrayList<>();
        addChild(mother);
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mother = null;
        this.father = null;
        this.children = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person parent) {
        if (parent != null)
            parent.children.add(this);
    }


    @Override
    public String toString() {
        String result = "\nname: " + name + "; age: " + age + "; sex: " + sex;

        if (father != null)
            result += "\nfather: " + father.name;

        if (mother != null)
            result += "\nmother: " + mother.name;

        if (children.size() > 0) {
            result += "; ";
            for (int i = 0; i < children.size(); i++) {
                result += "\nchild: " + children.get(i).name;
            }
        }
        result += "\n";
        return result;
    }



    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}

