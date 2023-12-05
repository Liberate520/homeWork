package family_tree;

import human.Gender;
import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private long countPeople;
    private List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public boolean addHumanInTree(Human human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            human.setId(countPeople++);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!(familyTree.isEmpty())) {
            for (Human human : familyTree) {
                    sb.append("Id:" + human.getId() + " " + human.getName() + " Возраст: " + human.getAge());
                    if(human.getGender().equals(Gender.Mail)){
                        sb.append(" " + "Мужчина" + "\n");
                    } else {
                        sb.append(" " + "Женщина" + "\n");
                    }
                    if(human.getChild() != null){
                        sb.append("Дети: " +"\n"+ human.getChild() +  "\n");
                    }
            }
        }
        return sb.toString();
    }
}
