import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    String name;
    int age;
    Human Mother,Father;
    List<Human> child;

    LocalDate Ld;
    Gender gender;

    public Human(String name, int age) {
        child = new ArrayList<>();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human getMother() {
        return Mother;
    }

    public void setMother(Human mother) {
        Mother = mother;
    }

    public Human getFather() {
        return Father;
    }

    public void setFather(Human father) {
        Father = father;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Mother=" + Mother +
                ", Father=" + Father +
                '}';
    }

    public void addChildren(Human human){
        child.add(human);
    }

    public List<Human> getChild() {
        return child;
    }

    public void setChild(List<Human> child) {
        this.child = child;
    }
}
