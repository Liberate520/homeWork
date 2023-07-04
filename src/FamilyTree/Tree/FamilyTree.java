package FamilyTree.Tree;



import FamilyTree.Human.Human;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int id;
    private int humanID;
    private List<Human> humanList;

    public FamilyTree(int id){
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human Human){
        Human.setId(humanID++);
        humanList.add(Human);
    }

    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список человек в генеалогическом древе: \n");
        for (Human Human : humanList){
            stringBuilder.append("id " + id++);
            stringBuilder.append(Human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
