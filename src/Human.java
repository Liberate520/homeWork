import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    String name;
    int age;
    Gender gender;
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


    public int getAge() {
        return age;
    }


    public void setMother(Human mother) {
        Mother = mother;
    }


    public void setFather(Human father) {
        Father = father;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }


    public List<Human> getChild() {
        return child;
    }

    public void setChild(List<Human> child) {
        this.child = child;
    }
}
