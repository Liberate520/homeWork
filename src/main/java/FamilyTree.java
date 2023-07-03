import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class FamilyTree {
    private List<Human> familyList;


    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> familyList) {
        this.familyList = familyList;
    }

    public void add(Human hum) {
        if (!familyList.contains(hum)) {
            familyList.add(hum);
            addToMother(hum);
            addToFather(hum);
            addToChild(hum);
        }
    }

    private void addToMother(Human human) {
        if(human.getMother() != null) human.getMother().addChild(human);
    }

    private void addToFather(Human human) {
        if (human.getFather() != null) human.getFather().addChild(human);
    }

    private void addToChild(Human human) {
        for (Human child : human.getChildrenList()) {
            if (human.getgGender() == Gender.Man) child.setFather(human);
            else child.setMother(human);
        }
    }

    public String getInfo() {
        familyList.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("В дерево добавлено: ");
        sb.append(familyList.size());
        sb.append(" человек \n");
        for (Human human : familyList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

}
