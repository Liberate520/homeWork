package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.base.TreeHub;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<E extends TreeHub<E>> {
    private double Id;
    private final List<Human<?>> humanList;


    public FamilyTree(double id) {
        humanList = new ArrayList<>();

    }

    public void addHuman(Human<?> human){
        human.setId(Id++);
        humanList.add(human);

    }

    public String getRelativeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список :\n");
        for (Human<?> human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }




}