package faminly_tree.model.human;

import java.util.ArrayList;
import java.util.List;

public class HumanConnection implements HumanConnectionToService{

    /**
     * Создание взаимосвязи ребенок-родитель
     * @param child ребенок
     * @param parent родитель
     */
    public void childFor(Human child, Human parent) {
        if (parent.getGender() == Gender.Male) {
            child.setFather(parent);
        } else {
            child.setMother(parent);
        }
        List<Human> children = parent.getChildren();
        if (children == null) {
            children = new ArrayList<>();
            children.add(child);
        } else children.add(child);
        parent.setChildren(children);
    }
    //TODO метод брака
    //TODO метод развода

}
