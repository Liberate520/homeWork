import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        this (new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
        }
    }

    public String getInfo() {
        StringBuilder ft = new StringBuilder();
        ft.append("Всего " + humanList.size() + " родственников");
        for (Human k: humanList) {
            ft.append(k);
            ft.append("\n");
        }
        return ft.toString();
    }
}