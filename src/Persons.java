import java.util.ArrayList;

public class Persons implements Humans {

    private String name;
    private int age;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    /* @Override
    public int compareTo(Nodes o) {
        return name.compareTo(o.p1.name);
    } */

   /*  @Override
    public int compareTo(ArrayList<Nodes> o) {
        return name.compareTo(o.);
    } */

}
