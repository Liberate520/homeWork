import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> humanList;

    public Tree() {
        this.humanList = new ArrayList<>();
    }

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            Human father = human.getFather();
            Human mother = human.getMother();
            if (father != null) {
                father.addChild(human);
            }
            if (mother != null) {
                mother.addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human findHumanName(String name) {
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getChildrenOfHuman(Human human) {
        List<Human> children = new ArrayList<>();
        for (Human h : humanList) {
            if (h.getFather() == human || h.getMother() == human) {
                children.add(h);
            }

        }
        if(children.isEmpty()){
            children.add(new Human("Нет детей"));
        }

        return children;
    }

    public List<Human> getParentsOfHuman(Human human) {
        List<Human> parents = new ArrayList<>();
        for (Human h : humanList) {
            if (h.getChildren().contains(human)) {
                parents.add(h);
            }

        }
        if(parents.isEmpty()){
            parents.add(new Human("Нет родителей"));
        }
        return parents;
    }

    public String getHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}