package familyTree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private int idHuman;
    private List<Human> humanList;

    //    public FamilyTree() { humanList = new ArrayList<>(); };
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean addHuman(Human human) {
        human.setId(idHuman++);
//        humanList.add(human);
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getByName(String surname, String name, String patronymic) {
        for (Human human : humanList) {
            if ((human.getSurname().equals(surname)) &&
                    (human.getName().equals(name)) &&
                    (human.getPatronymic().equals(patronymic))) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Список всех учтенных родственников в семейном дереве:\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        sb.append("Всего учтенных родственников в семейном дереве: ");
        sb.append(humanList.size() + "\n");

        return sb.toString();
    }


}
