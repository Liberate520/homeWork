import java.util.*;
import java.io.Serializable;

public class FamilyTree implements Serializable {
    private List<Human> listHuman;

    public FamilyTree() { 
        this(new ArrayList<>());
    }
    
    public FamilyTree(List<Human> listHuman) {
        this.listHuman = listHuman;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!listHuman.contains(human)) {
            listHuman.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human); // если в переданом хумане есть отец/мать, то добавляется ребенок к этим родителям
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for (Human human : listHuman) {
            if (human.getName() == name) {
                return human;
            }
        }
        return null;
    }

    public String getInfoTree() {
        StringBuilder sb = new StringBuilder();
        for (Human human : listHuman) {
            sb.append(human.getInfo());
        }
        return sb.toString();
    }

}

