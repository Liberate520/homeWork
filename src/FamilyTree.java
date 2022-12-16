package ForkDZ.OOP_homeWork_1.src;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human human) {
        humans.add(human);
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

}
