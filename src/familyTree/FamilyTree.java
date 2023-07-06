package familyTree;

import human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int idHuman;
    private List<Human> humanList;

    public FamilyTree() { humanList = new ArrayList<>(); };

    public void addHuman (Human human) {
        human.setId(idHuman++);
        humanList.add(human);
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
