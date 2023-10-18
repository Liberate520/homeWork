import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
        System.out.println("humanList");
    }
    public FamilyTree() {
        this(new ArrayList<>());
        System.out.println("ArrayList");
    }

    public boolean addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            return true;
        }
        return false;
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