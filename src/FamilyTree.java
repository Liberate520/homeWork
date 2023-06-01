import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
    }

    public String getHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getFirstName().equals(name)) {
                return human.getInfo();
            }
        }
        return null;
    }

    public String getHumanByBirthDate(String birthDate) {
        for (Human human : humanList) {
            if (human.getBirthDate().getYear() == Integer.parseInt(birthDate)) {
                return human.getInfo();
            }
        }
        return null;
    }

    public String getHumanList() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}
