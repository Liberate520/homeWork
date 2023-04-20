import java.io.*;
import java.util.Objects;

public class Person implements Serializable, FileWorkable{
    private int age;
    private int gender;
    private String name;
    private Person mother;
    private  Person father;

    public Person(int age, int gender,String name, Person mother, Person father) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.mother = mother;
        this.father = father;
    }

    public Person(int age, int gender,String name) {
        this(age,gender,name,null,null);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person person) {
            return name.equals(person.name)&&age==(person.age);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }
    @Override
    public String toString() {
        return "Person [" + getInfo()+"]";
    }
    public String getInfo(){
        return name  + " age: "+age + gender;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public String getGender() {
        if (gender==0){
            return "Female";
        }
        return "Male";
    }


}
