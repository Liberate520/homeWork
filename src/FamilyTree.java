import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if ((human.getMother() != null)) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве: ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }


    public Human getByFirstName(String firstname) {
        for (Human human : humanList) {
            if (human.getFirstName().equals(firstname)) {
                return human;
            }
        }
        return null;
    }

    public Human getByChildren(List<Human> children) {
        for (Human human : humanList) {
            if (human.getChildren().equals(children)) {
                return human;
            }
        }
        return null;
    }

    public Human getByBrothers(List<Human> brothers) {
        for (Human human : humanList) {
            if (human.getBrothers().equals(brothers)) {
                return human;
            }
        }
        return null;
    }

    public Human getBySisters(List<Human> sisters) {
        for (Human human : humanList) {
            if (human.getSisters().equals(sisters)) {
                return human;
            }
        }
        return null;
    }
}
