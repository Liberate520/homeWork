import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private List<Person> children;
    private String name;
    private int age;
    private String sex;
    private Person mother;
    private Person father;



    public Person (String name, int age, String sex, Person mother, Person father){
        this.name = name;
        this.age = age;
        this.sex= sex;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        mother.getChild().add(this);
        if (this.father != null) father.getChild().add(this);
    }

    public Person (String name, int age, String sex, Person mother){
        this.name = name;
        this.age = age;
        this.sex= sex;
        this.mother = mother;
        this.father = null;
        this.children = new ArrayList<>();
        mother.getChild().add(this);
    }

    public Person (String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mother = null;
        this.father = null;
        this.children = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public List<Person> getChild() {
        return this.children;
    }



    @Override
    public String toString() {
        if (this.children.size() == 0) {
            if (this.father == null && this.mother == null) {
                return String.format("\nname: %s, age: %d, sex: %s",
                        this.name, this.age, this.sex);
            } else if (this.father == null) {
                return String.format("\nname: %s, age: %d, sex: %s\nMother: %s",
                        this.name, this.age, this.sex, this.mother.getName());
            } else {
                return String.format("\nname: %s, age: %d, sex: %s\nMother: %s\nFather: %s",
                        this.name, this.age, this.sex, this.mother.getName(), this.father.getName());
            }
        } else {
            if (this.father == null && this.mother == null) {
                return String.format("\nname: %s, age: %d, sex: %s\n   Children: %s",
                        this.name, this.age, this.sex, this.children.toString().replaceAll("^\\[|\\]$", ""));
            } else if (this.father == null) {
                return String.format("\nname: %s, age: %d, sex: %s\nMother: %\n   Children: %s",
                        this.name, this.age, this.sex, this.mother.getName(), this.children.toString().replaceAll("^\\[|\\]$", ""));
            } else {
                return String.format("\nname: %s, age: %d, sex: %s\nMother: %s\nFather: %s\n   Children: %s",
                        this.name, this.age, this.sex, this.mother.getName(), this.father.getName(), this.children.toString().replaceAll("^\\[|\\]$", ""));
            }
        }


    }


}


//    @Override
//    public String toString() {
//        if (this.children.size() == 0)
//            return String.format("\nname: %s, age: %d, sex: %s",
//                    this.name, this.age, this.sex);
//        else if (this.father == null && this.mother == null)
//            return String.format("\nname: %s, age: %d, sex: %s\nChildren: %s",
//                    this.name, this.age, this.sex, this.children.toString().replaceAll("^\\[|\\]$", ""));
//        else if (this.father == null)
//            return String.format("\nname: %s, age: %d, sex: %s\nMother: %s\nChildren: %s",
//                    this.name, this.age, this.sex, this.mother, this.children.toString().replaceAll("^\\[|\\]$", ""));
//        else
//            return String.format("\nname: %s, age: %d, sex: %s\nMother: %s\nFather: %s\nChildren: %s",
//                    this.name, this.age, this.sex, this.mother.getName(), this.father.getName(), this.children.toString().replaceAll("^\\[|\\]$", ""));
//    }
