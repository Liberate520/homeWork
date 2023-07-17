package Homework.model.service;

import Homework.model.Human.Gender;
import Homework.model.Human.Human;
import Homework.model.Tree.FamilyTree;

import java.time.LocalDate;

public class Service {

    private FamilyTree familyTree;

    public Service() { familyTree = new FamilyTree<>();}

    public void addHuman(String name, Gender gender, LocalDate birth){
        Human human = new Human(name, gender, birth);
        familyTree.addHuman(human);
    }

    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо: \n");
        for (Object human: familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() { familyTree.sortByName(); }

    public void sortByAge() { familyTree.sortByAge(); }

    public void sortByChildren() { familyTree.sortByChildren();}
}
