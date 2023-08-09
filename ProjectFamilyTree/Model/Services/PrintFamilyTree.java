package homeWork.ProjectFamilyTree.Model.Services;

import homeWork.ProjectFamilyTree.Model.Family_tree;
import homeWork.ProjectFamilyTree.Model.Human;

public class PrintFamilyTree {
    private Family_tree<Human> familyTree;

    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
