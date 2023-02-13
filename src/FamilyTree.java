import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    private FamilyTree(List<Human> humans) {
        this.humans = humans;
    }
    
    public String getChildrenToString(Human human) {
        String res = "Дети от родителя "+ human.getInfo()+": ";
        List<Human> children = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getFather() == human){
                children.add(humans.get(i));
            }
        }
        for (int i = 0; i < children.size(); i++) {
            res = res +"\n"+(i+1) +"). " +children.get(i).getInfo();
        }
        return res;
    }



    public String getAllHumanToString() {        
        String res = "Генеологическое дерево: ";
        List<Human> list1 = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            list1.add(humans.get(i));
        }       
        for (int i = 0; i < humans.size(); i++) {
            res = res +"\n"+(i+1) +"). " +humans.get(i).getInfo();
        }
        return res;
    }

    public void setHumans(Human human) {
        humans.add(human);
    }
}
