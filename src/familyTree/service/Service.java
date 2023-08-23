package familyTree.service;

import familyTree.famTree.FamilyTree;
import human.Human;

public class Service {
    private long id;
    private FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree(0);
    }

    public void addHuman(String name, int age){
        Human human = new Human(id++, name, age);
        familyTree.addHuman(human);
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
