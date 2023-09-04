package ru.gb.family_tree.model;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.filehandler.Writable;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class TreeService {
    private int id;
    private Writable writable;
    private FamilyTree<Human> activeTree;

    public TreeService(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public TreeService(){
        activeTree = new FamilyTree<>();
    }



//    public String addHuman(String name, String genderString, String birthDate,
//                           long idFather, long idMother){
//        Human father = activeTree.getById(idFather);
//        Human mother = activeTree.getById(idMother);
//        Gender gender = Gender.valueOf(genderString);
//        LocalDate humanBirthDate = LocalDate.parse(birthDate);
//        Human human = new Human(name, gender, humanBirthDate, father, mother);
//        activeTree.add(human);
//        return "Человек успешно добавлен в дерево";
//    }

    public void addHuman(String name, Gender gender, LocalDate birthdate, int age, int id) {
        Human human = new Human(name, gender, birthdate, age, id++);
        activeTree.add(human);
    }

    public void addChild(String name, int age) {
        Human human = new Human(name, null, null, age, id);
        activeTree.add(human);
    }

    public void addParent(String name, int age) {
        Human human = new Human(name, null, null, age, id);
        activeTree.add(human);
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByAge(){
        activeTree.sortByAge();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }

    public boolean write(){
        if (writable == null){
            return false;
        }
        return writable.write(activeTree);
    }

    public boolean read(){
        if (writable == null){
            return false;
        }
        activeTree = writable.read();
        return true;
    }
}
