package DZ1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> humans = new ArrayList<>();

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human human) throws IOException {
        humans.add(human);

    }

    public void clearTree() {
        humans.clear();
    }

    public List<Human> getAllHumans() {
        return humans;
    }

    public Human getHumanByName(String name) {
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String gethumanByNameAndRelatives(String name) {
        String personName = null;
        Human person = null;
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                personName = human.getName();
                person = human;
            }
        }
        return "Имя: " + personName + ", Отец: " + person.getFather() + ", Мать: " + person.getMother() + ", Дети: "
                + person.getChildren() + ", Братья и сестры: " + person.getBrothersOrSisters();
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    public void addList(List<Human> read) {
        humans.addAll(read);
    }

}
