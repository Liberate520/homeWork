import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class FamilyThree implements Serializable{
    private List<Human> humans;

    public FamilyThree() {
        this(new ArrayList<>());
    }

    public FamilyThree(List<Human> humans) {
        this.humans = humans;
    }

    public void addHuman(Human human) {
        if (human == null) {
            return;
        };
        if (!humans.contains(human)){
            humans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }
    public void printTree(Human human) {
        System.out.println("Person: " + human.toString());
        List<Human> children = human.getChildren();
        if (children.size() != 0) {
            for (Human child : children) {
                System.out.println("  " + "Дети:" + " " + child);
            }
        } else {
            System.out.println(" Дети: Нет детей");
        }

    }

    public List<Human> getHumans() {
        return humans;
    }
    public void sortByName(){
        humans.sort(new FamilyComparatorByName<>());
    }

    public void sortByChild(){
        humans.sort(new FamilyComparatorByChildrens<>());
    }
}

