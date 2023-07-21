package FamilyTree;

import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addToList(Human human) {
        familyTree.add(human);
    }

    public void findByName(String name) {
        boolean flag = false;
        for (Human member : familyTree) {
            if (member.getName().equalsIgnoreCase(name)) {
                flag = true;
                System.out.println(member);
            }
        }
        if (!(flag)) {
            System.out.println("Такого человека нет");
        }
    }

    public String getInfoFamilyTree() {
        StringBuilder info = new StringBuilder();
        for (Human human : familyTree) {
            info.append(human);
            int length = human.getInfo().length();
            info.append("\n");
            String str = "";
            for (int i = 0; i < length; i++) {
                str += "-";
            }
            info.append(str);
            info.append("\n");
        }
        return info.toString();
    }
}