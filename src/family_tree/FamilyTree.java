package family_tree;

import human.Human;
import human.Gender;
import human.ComparatorByName;
import human.ComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> tree = new ArrayList<>();
    private HashMap<E, E> fathersList = new HashMap<>();
    private HashMap<E, E> mothersList = new HashMap<>();

    public void addPerson(E human) {
        tree.add(human);
    }

    public void addFather(String surname, String name, String patronymic, Gender gender, int birthYear, int birthMonth, int birthDay, E human) {
        E father = (E) new Human (surname, name, patronymic, Gender.Male, birthYear, birthMonth, birthDay);
        tree.add(father);
        fathersList.put(human, father);
        human.setFather(father);
        List<E> children = father.getChildren();
        if (children == null) {
            children = new ArrayList<>();
            children.add(human);
        } else children.add(human);
        father.setChildren(children);
    }

    public void addMother(String surname, String name, String patronymic, Gender gender, int birthYear, int birthMonth, int birthDay, Human human) {
        E mother = new E (surname, name, patronymic, Gender.Female, birthYear, birthMonth, birthDay);
        tree.add(mother);
        mothersList.put((E) human, mother);
        human.setMother((Human) mother);
        List<E> children = mother.getChildren();
        if (children == null) {
            children = new ArrayList<>();
            children.add((E) human);
        } else children.add((E) human);
        mother.setChildren(children);
    }

    public String findParents(E human) {
        StringBuilder parents = new StringBuilder();
        E father = fathersList.get(human);
        E mother = mothersList.get(human);
        if (father != null) parents.append("Отец:\n" + father + "\n");
        else parents.append("Отец не найден\n");
        if (mother != null) parents.append("Мать:\n" + mother + "\n");
        else parents.append("Мать не найдена\n");
        return parents.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }


    @Override
    public String toString() {
        return tree.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(tree);
    }
    public void sortByName() {
        Collections.sort(tree, new ComparatorByName());
    }
    public void sortByAge() {
        Collections.sort(tree, new ComparatorByAge());
    }
}