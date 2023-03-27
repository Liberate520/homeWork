import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public Human getByName(String name) {
        for (Human human :
                humanList) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }

    public Human getBySurname(String surname) {
        for (Human human :
                humanList) {
            if (human.getSurname().equals(surname))
                return human;
        }
        return null;
    }


    public void addHuman(Human human) {
        humanList.add(human);
    }


}
