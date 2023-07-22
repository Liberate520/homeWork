import human.Human;
import tree.FamilyTree;

import java.util.Collections;

public class Service {
    private FamilyTree familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей: \n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

}
