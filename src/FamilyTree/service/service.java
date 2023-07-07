package FamilyTree.service;

import FamilyTree.Human.Human;
import FamilyTree.Tree.FamilyTree;

public class service {
    public String getHumanInfo(FamilyTree familyTree){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди:\n");
        for (Human human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
