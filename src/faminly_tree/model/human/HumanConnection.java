package faminly_tree.model.human;

import java.util.ArrayList;
import java.util.List;
//Human реализует интерфейс FamiliItem, который обязывает его содержать те методы, которые используются в этом классе,
// поэтому не нарушается 5 принцип SOLID
public class HumanConnection {

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
