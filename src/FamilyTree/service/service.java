package FamilyTree.service;

import FamilyTree.Human.Human;
import FamilyTree.Tree.FamilyTree;

public class Service {
    public String getHumanInfo(FamilyTree familyTree){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди:\n");
        for (Object human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
