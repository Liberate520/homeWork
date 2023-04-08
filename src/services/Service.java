package services;

import family.FamilyTree;
import human.Human;

import java.util.Comparator;


public class Service {
    private final FamilyTree family;

    public Service(FamilyTree family){
        this.family = family;
    }

    public FamilyTree getFamily() {
        return family;
    }

    /**
     * Метод добавляет человека в семью.
     */
    public void addHuman(Human human) {
        family.getPeople().add(human);
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
    }
    public void sortHuman(Comparator<Human> comp){
        family.getPeople().sort(comp);
    }
}
