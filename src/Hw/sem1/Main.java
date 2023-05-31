package Hw.sem1;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("John");
        Person person2 = new Person("Jane");
        Person person3 = new Person("Tom");


        FamilyTree familyTree = new FamilyTree(person1);


        familyTree.addChild(person1, person2);
        familyTree.addChild(person1, person3);


        List<Person> children = familyTree.getChildren(person1);


        System.out.println("Children of " + person1.getName() + ":");
        for (Person child : children) {
            System.out.println(child.getName());
        }
    }
}