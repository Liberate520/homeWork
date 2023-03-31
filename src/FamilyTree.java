
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> humanList = new ArrayList<>();

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> familyList) {
        this.humanList = familyList;
    }

    // метод проверки наличия человека в листе и при его отсутствии добавление
    // человека

    public boolean addNewHuman(Human human, List<Human> list) {

        if (human == null) {

            return false;

        }
        if (!humanList.contains(human)) {

            humanList.add(human);
            if (human.getFather() != null) {

                human.getFather().addChildren(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChildren(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public Human getByFamily(String fam) {
        for (Human human : humanList) {
            if (human.getFamily().equals(fam)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder infoRes = new StringBuilder();
        infoRes.append("В дереве \n");
        infoRes.append(humanList.size() + " ");
        infoRes.append("объекта(ов)\n");
        for (Human human : humanList) {
            infoRes.append(human.getInfo());
        }

        return infoRes.toString();

    }


}
