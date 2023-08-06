import human.Human;
import human.Person;
import tree.FamilyTree;

import java.util.Collections;

public class Service {
    private FamilyTree<Person> familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей: \n");
        for (Person human: familyTree){
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
