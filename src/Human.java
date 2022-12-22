import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String gender;
    private int age;
    Human father;
    Human mother;
    List<Human> children;

    public Human(String name, String gender, int age, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        children = new ArrayList<>();
        this.father = father;
        if(father != null) {
            father.children.add(this);
        }
        this.mother = mother;
        if(mother != null) {
            mother.children.add(this);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        String res = "\n" + name + " " + gender  + " " + age + " y.o.";
        if(father != null) {
            res = res + ", father: " + father.getName();
        }
        if(mother != null) {
            res = res + ", mother: " + mother.getName();
        }
        return res;
    }
}
