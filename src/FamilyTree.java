import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList = new ArrayList<>();
    private int humanId = 1;

    public void addFamilyTree(Human human) {
        if (!humanList.contains(human)) {
            human.setId(humanId++);
            humanList.add(human);
            addToParrents(human);
            addToChildren(human);
        }}
    public void addToParrents(Human human){
        for (Human parent: human.getParrent()){
            parent.addChildren(human);
        }
    }
    public void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

        public String familyTreeInfo () {
            StringBuilder sb = new StringBuilder();
            for (Human human : humanList) {
                sb.append(human);
                sb.append("\n");
            }
            return sb.toString();
        }
    }
