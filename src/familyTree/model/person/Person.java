package familyTree.model.person;

import familyTree.model.TreeItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable,TreeItems<Person> {
    private int age;
    private String gender;
    private String name;
    private Person mother;
    private  Person father;
    private List<Person> children;

    public Person(int age, String gender,String name, Person mother, Person father) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.mother = mother;
        this.father = father;
        children=new ArrayList<>();
    }
    public Person(int age, String gender,String name) {
        this(age,gender,name,null,null);
    }

    public void addChild (Person child){
        if(!children.contains(child)){
            children.add(child);
        }
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
        return "Person.Person [" + getInfo()+"]";
    }
    public String getInfo(){
        return name  + " age: "+age + " пол: "+ gender;
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
    public int getGender() {
        if (gender.equals("Female")){
            return 0;
        }
        return 1;
    }
    public int getAge() {
        return age;
    }

}