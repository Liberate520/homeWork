package ru.gb.family_tree.tree;

import ru.gb.family_tree.exception.HumanExcistsException;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorById;
import ru.gb.family_tree.human.comparators.HumanComparatorByLastname;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E> {

    private String family;
    private List<E> familyMembers;
    private int memberId = 1; // хочу нумерацию людей с 1

    public FamilyTree(String family) {
        this.family = family;
        familyMembers = new ArrayList<>();
    }

    public void tryAdd (E human) throws HumanExcistsException {
        if (familyMembers.contains(human)) {
            throw new HumanExcistsException("Такая запись уже есть!");
        }
    }
    public void addMember (E human) {
        human.setId(memberId++);
        try {
            tryAdd(human);
            if (!familyMembers.contains(human)) {
                familyMembers.add(human);
            }
        } catch (HumanExcistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public String allMembers () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья " + family + ": \n");
        for (E member: familyMembers) {
            stringBuilder.append(member).append("\n");
        }
        return stringBuilder.toString();
    }

    public E findInTree (int id) {
        for (E member : familyMembers) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }


    public String infoById (int id) {
        StringBuilder sb = new StringBuilder("Id - ");
        sb.append(id). append("\n").append("Семья: ").append(family).append("\n");
        E human = findInTree(id);
        sb.append("Фамилия: ").append(human.getLastname() + "\n");
        sb.append("Имя: ").append(human.getName() + "\n");
        sb.append("Пол: ").append(human.getGender() + "\n");
        if (human.getBirthday() != null) {
            sb.append("Дата рождения: ").append(human.getBirthday() + "\n");
            sb.append("Возраст: ").append(human.getAge() + "\n");
        }
        if (human.getSpouse() != null) {
            sb.append(human.getSpouse() + "\n");
        }
        if (human.getParents() != null) {
            sb.append(human.getParents() + "\n");
        }
        if (human.getChildren() != null) {
            sb.append(human.getChildren() + "\n");
        }
        return sb.toString();
    }

    public String allInDetails () {
        StringBuilder sb = new StringBuilder();
        sb.append("Генеалогическое древо ").append(family).append("\n");
        int id = 1;
        for (E member : familyMembers) {
            sb.append(infoById(id++)).append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        familyMembers.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        familyMembers.sort(new HumanComparatorByAge());
    }

    public void sortById() {
        familyMembers.sort(new HumanComparatorById());
    }

    public void sortByLastname() {
        familyMembers.sort(new HumanComparatorByLastname());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyMembers);
    }
}

