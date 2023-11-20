package model.service;

import model.human.Gender;
import model.human.Human;
import model.group.FamilyTree;

import java.time.LocalDate;

public class Service {
    private FamileTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addHuman(String name, int age) {
        Human human = new Human(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent);
        tree.addHuman();
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список :\n");

//        Iterator<Student> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }
        for (Human k : tree){
            stringBuilder.append(k);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }
}
