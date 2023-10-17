package model.family_tree;

import model.saving.serialization.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> extends FileHandler implements Iterable<E>{
    /*понимаю, что наследование выполнено ошибочно, но по другому не получается( */
    private List<E> peopleList;
    private String familyName;
    private int count = 1;

    public FamilyTree(String familyName) {
        this.familyName = familyName;
        peopleList = new ArrayList<>();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void addInFamily(E person) {
        person.setId(count++);
        peopleList.add(person);
    }

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(familyName);
        stringBuilder.append(":\n");
        for (E person: peopleList) {
            stringBuilder.append(person.getId());
            stringBuilder.append(". ");
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }
    public int size() {
        return peopleList.size();
    }

    public void isHusbands (E person1, E person2) {

        List<E> person1Husbands = person1.getHusbands();
        person1Husbands.add(person2);
        person1.setHusband(person1Husbands);

        List<E> person2Husbands = person2.getHusbands();
        person2Husbands.add(person1);
        person2.setHusband(person2Husbands);

    }

    public void isChildren (E children, E father, E mother) {

        children.setMother(mother);
        children.setFather(father);

        List<E> fatherChild = father.getChildren();
        fatherChild.add(children);
        father.setChildren(fatherChild);

        List<E> motherChild = mother.getChildren();
        motherChild.add(children);
        mother.setChildren(motherChild);
    }

    public String getPersonInfo(E person) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(person.getName());
        stringBuilder.append(":\n\n");

        if (!person.getChildren().isEmpty()) {
            stringBuilder.append("Дети:\n");
            for (E child: person.getChildren()) {
                stringBuilder.append(child);
            }
            stringBuilder.append("\n");
        }

        if (!person.getHusbands().isEmpty()) {
            stringBuilder.append("Супруги:\n");
            for (E husband: person.getHusbands()) {
                stringBuilder.append(husband);
            }
            stringBuilder.append("\n");
        }

        if (person.getMother() != null) {
            stringBuilder.append("Мать:\n");
            stringBuilder.append(person.getMother());
            stringBuilder.append("\n");
        }

        if (person.getFather() != null) {
            stringBuilder.append("Отец:\n");
            stringBuilder.append(person.getFather());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getFamilyInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(peopleList);
    }

    public void sort(Comparator<E> comparator) {
        peopleList.sort(comparator);
    }
}
