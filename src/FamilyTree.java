package DZ1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {

    private List<T> humans = new ArrayList<>();

    public FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(T human) {
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

    public List<T> getAllHumans() {
        return humans;
    }

    public Human getHumanByName(String name) {
        for (T human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getHumanByNameAndRelatives(String name) {
        String personName = null;
        Human person = null;
        for (T human : humans) {
            if (human.getName().equals(name)) {
                personName = human.getName();
                person = human;
            }
        }
        return "Имя: " + personName + ", Отец: " + person.getFather() + ", Мать: " + person.getMother() + ", Дети: "
                + person.getChildren() + ", Братья и сестры: " + person.getBrothersOrSisters();
    }

    public List<T> getHumans() {
        return humans;
    }

    public void setHumans(List<T> humans) {
        this.humans = humans;
    }

    public void addList(List<T> read) {
        humans.addAll(read);
    }

    @Override
    public Iterator<T> iterator() {

        return new FamilyTreeIterator(humans);
    }

}
