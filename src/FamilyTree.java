import java.util.ArrayList;
import java.util.List;
public class FamilyTree {
    private String name;
    private ArrayList<Human> humanList;
    public FamilyTree(String name) {
        this.name = name;
        humanList = new ArrayList<>();
    }
    public void addHuman(Human human) {
        this.humanList.add(human);
    }
    public void addHumanAll(Human... humans) {
        for(Human human : humans) {
            this.addHuman(human);
        }
    }
    public String getProductInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое дерево " + this.name + ":\n");
        for (Human human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Human> getHumanList() {
        return humanList;
    }
    public void setHumanList(ArrayList<Human> humanList) {
        this.humanList = humanList;
    }
    public String getAllChildren(Human human) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Все дети " + human.getLastName() + " " + human.getFirstName() + " " + human.getMiddleName() + ":\n");
        for (Human child: human.getChildren()) {
            stringBuilder.append(child);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}