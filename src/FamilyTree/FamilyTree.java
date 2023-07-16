package FamilyTree;

import Human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree = new ArrayList<>();

//    public FamilyTree() {
//        this.familyTree = familyTree;
//    }

    public void addToList(Human human) {
        familyTree.add(human);
    }

    public void findByName(String name) {
        boolean flag = false;
        for (Human member : familyTree) {
            if (member.name.equalsIgnoreCase(name)) {
                flag = true;
                System.out.println(member);
            }
        }
        if (!(flag)) {
            System.out.println("Такого человека нет");
        }
    }

    public void getInfoFamilyTree() {
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }
}