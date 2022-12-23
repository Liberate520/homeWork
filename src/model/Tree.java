package model;

import java.util.ArrayList;
import java.util.List;

// может дерево сделать интерфейсом?

public class Tree <T extends TreePerson> { // в дереве можно хранить только подходящие классы human и animal
    // В дереве храним всех добавляемых людей
    private List<Human> humanList = new ArrayList<>();
    private List<Animal> animalList = new ArrayList<>();
//    List<Human<Link>> links;


    //когда создаём новое дерево
    public Tree() {
    }

//
    public List<Human> getHumanList() {
        return humanList;
    }
    public Human getHumanList(int i) {
        return humanList.get(i);
    }
//
//
    // добавляем человека в дерево
//    @Override
    public void add(T person) {
        if(person instanceof Human)
            this.humanList.add((Human) person);
        if(person instanceof Animal)
            this.animalList.add((Animal) person);
    }
//    public void addTree() {
//        this.addTree(this);
//    }
//
//    @Override
//    public void printTree() {
//
//        //ищем начало дерева
//        int max = 0;
//        for (FamiliesI person : Tree.getHumanList()) {
//            for (Link link : person.getLink()){
//
//            }
//        }
//
//    }
//


}
