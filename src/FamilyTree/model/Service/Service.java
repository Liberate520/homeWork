package FamilyTree.model.Service;

import FamilyTree.model.Human.comparators.SortByAge;
import FamilyTree.model.Human.comparators.SortByName;
import FamilyTree.model.Tree.FamilyTree;
import java.util.List;

public class Service<T>{

    private int id = -1;
    private List<T> list;
    private FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree(id++);
    }

    public void addHuman(T human){
        familyTree.addHuman(human);
    }

    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список:\n");
        for (Object obj : familyTree){
            stringBuilder.append(obj);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByAge() {
        list.sort(new SortByAge());
    }

    public void sortByName(){
        list.sort(new SortByName());
    }
}
