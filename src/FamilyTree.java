package DZ1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {

    private List<Human> humans = new ArrayList<>();

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human human) {
        humans.add(human);

    }

    public void clearTree() {
        humans.clear();
    }

    public void sortByName() {
        Collections.sort(humans);
    }

    public void sortByGender() {
        Collections.sort(humans, new HumanComparatorByGender());
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

    public String getHumanByNameAndRelatives(String name) {
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

    @Override
    public Iterator<Human> iterator() {

        return new FamilyTreeIterator(humans);
    }

}
