package family_tree.family_tree;

import family_tree.base.Iterable;
import family_tree.human.Human;
import family_tree.base.Iterable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Iterable {
    public String lastName;
    public String firstName;

    private double Id;
    private final List<Human> humanList;


    public FamilyTree(double id) {
        humanList = new ArrayList<>();

    }

    public void addHuman(Human human){
        human.setId(Id++);
        humanList.add(human);

    }

    public String getRelativeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список :\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public void sortByLastName(){
        FamilyTree familyTree = null;
        familyTree.sortByLastName();

    }

    @Override
    public String getLastName() {
        return null;
    }


    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setId(double id) {

    }


}