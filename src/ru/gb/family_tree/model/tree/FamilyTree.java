package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.exception.HumanExcistsException;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.model.human.comparators.HumanComparatorById;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByLastname;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E> {

    private List<E> familyMembers;
    private int memberId = 1; // хочу нумерацию людей с 1

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public void tryAdd(E human) throws HumanExcistsException {
        if (familyMembers.contains(human)) {
            throw new HumanExcistsException("Такая запись уже есть!");
        }
    }

    public void addMember(E human) throws HumanExcistsException {
        human.setId(memberId++);
        tryAdd(human);
        if (!familyMembers.contains(human)) {
            familyMembers.add(human);
        }
    }

    public String getInfoShort() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E member : familyMembers) {
            stringBuilder.append(member);
            if (member.getBirthday() == null) {
                stringBuilder.append(", возраст неизвестен\n");
            } else {
                stringBuilder.append(", возраст: ").append(member.age()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public E findInTree(int id) {
        for (E member : familyMembers) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }


    public String infoById(int id) {
        StringBuilder sb = new StringBuilder("Id - ");
        sb.append(id).append("\n").append("\n");
        E human = findInTree(id);
        if (human != null) {
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
        return "Данных нет.";
    }

    public void sortByName() {
        familyMembers.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        familyMembers.sort(new HumanComparatorByAge<>());
    }

    public void sortById() {
        familyMembers.sort(new HumanComparatorById<>());
    }

    public void sortByLastname() {
        familyMembers.sort(new HumanComparatorByLastname<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyMembers);
    }
}

