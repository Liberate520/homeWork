package familly_api.service;

import java.time.LocalDate;
import java.util.List;

import familly_api.familytree.FamilywTree;
import familly_api.human.Human;
import familly_api.human.Node;
import familly_api.savinaAnLoad.SavingFile;

public class Service {
    private FamilywTree<Node> familyList;
    private SavingFile saveLoad;

    public Service() {
        this.familyList = new FamilywTree<>();
    }

    public int getSize() {
        return familyList.getSize();
    }

    public String getHumanList() {
        return this.familyList.getInfo();
    }

    public void creatHuman(String firstName, String lastName, String middleName, LocalDate born, LocalDate death,
            String gender) {
        Human human = new Human(firstName, lastName, middleName, born, death, gender);
        Node humanN = new Node(human);
        this.familyList.add(humanN);
    }

    public void addByFamily(FamilywTree<Node> family, Node humanN) {
        family.add(humanN);
    }

    public void addChild(int child, int parent) {
        Node parentN = getNode(parent);
        Node childN = getNode(child);
        parentN.addChildOneParent(childN);
    }

    public Node getNode(int numberNode) {
        return familyList.getNode(numberNode);

    }

    public String searchName(String firstName) {
        familyList.searchName(firstName);
        List<Node> searchName = familyList.searchName(firstName);
        return getInfoForName(searchName);

    }

    public String getInfoForName(List<Node> searchName) {
        StringBuilder sb = new StringBuilder();
        sb.append("всего найденно: ");
        sb.append(searchName.size());
        for (Node node : familyList) {
            sb.append(node.getPeople().printHuman());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void getInfo(FamilywTree<Node> family) {
        family.getInfo();
    }

    public void sortByName() {
        familyList.sortByName();
    }

    public void sortByAge() {
        familyList.sortByAge();
    }

    public void saveFamily(String nameSaveFile) {
        saveLoad.saveFile(this.familyList, nameSaveFile);
    }

    public void loadFamily(String nameLoadFile) {
        this.familyList = saveLoad.loadFile(nameLoadFile);
    }

}
