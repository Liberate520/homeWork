package Tree.homeWork.src.model;

import Tree.homeWork.src.FamilyTreeGroup.FamilyTree;
import Tree.homeWork.src.HumanGroup.Gender;
import Tree.homeWork.src.HumanGroup.Human;

import java.util.ArrayList;
import java.util.List;

public class Service {
    // рабочий вариант

//    private List<String> list;
//
//    public Service() {
//        list = new ArrayList<>();
//        list.add("vdfgdfgdf");
//        list.add("dsasfasf");
//    }
//
//    public void addHuman(String firstName, String lastName) {
//        list.add(firstName + " " + lastName);
//    }
//    public String getHumanList(){
//        return list.toString();
//    }

    //-----------------------------------------------------------------------------------------------
    //  мой вариант
    private FamilyTree familyTree;
    private Human human;
    private List<FamilyTree> list;

    public Service() {
        list = new ArrayList<>();
    }

    public void addHuman(String name, int age, int DateOfBirth, int DateOfDeath, Gender gender,
                         Human father, Human mother) {
        familyTree.addHuman(new Human(name, age, DateOfBirth, DateOfDeath, gender, father, mother));
    }
    public String getHumanList(){
        return familyTree.toString();
    }
    public void sortByName() {
        familyTree.sortByName();
    }
    public void sortByAge() {
        familyTree.sortByAge();
    }
}
