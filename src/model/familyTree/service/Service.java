package model.familyTree.service;

import model.familyTree.famTree.FamilyTree;
import model.human.Human;
import model.write.Writable;

public class Service {
    private Writable writable;
    private int id;
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>(0);
    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(familyTree);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        familyTree = writable.read();
        return true;
    }

    public void addHuman(String name, String lastname,  int age){
        Human human = new Human(id++, name, lastname, age);
        familyTree.addHuman(human);
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    
    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи:\n");
//        Iterator<Human> iterator = familyTree.iterator();
//        while (iterator.hasNext()){
//            Human human = iterator.next();
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }
}
