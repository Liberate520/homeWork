package familyTree.famTree;

// import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import familyTree.HumanIterator;
import human.Human;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;

public class FamilyTree implements Iterable<Human> {
    private int id;
    private int humanId;
    private List<Human> humanList;

    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        human.setId(humanId++);
        humanList.add(human);
    }

    // public String getHumansInfo(){
    //     StringBuilder stringBuilder = new StringBuilder();
    //     stringBuilder.append("Члены семьи:\n");
    //     for (Human human: humanList){
    //         stringBuilder.append(human);
    //         stringBuilder.append("\n");
    //     }
    //     return stringBuilder.toString();
    // }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

}