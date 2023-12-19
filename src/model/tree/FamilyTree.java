package model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.exception.HumanExcistsException;
import model.tree.сomparators.ComparatorByAge;
import model.tree.сomparators.ComparatorByName;


public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private int id;
    private String family;
    private List<E> membersList;
    private int memberId = 1;


    public FamilyTree() {
        this.family = family;
        membersList = new ArrayList<>();
    }

    public void tryAdd(E human) throws HumanExcistsException{
        if (membersList.contains(human)){
            throw new HumanExcistsException("Такая запись уже существует");
        }
    }
    public void addMembers(E human) throws HumanExcistsException {
        human.setId(memberId++);
        tryAdd(human);
        if (!membersList.contains((human)))
            membersList.add(human);
    }

    public String getFamilyInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родословной:\n");
        for (E human: membersList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByAge() {
        membersList.sort(new ComparatorByAge<>());

    }
    public E findInTree(int id) {
        for (E member : membersList) {
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
        membersList.sort(new ComparatorByName<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(membersList);
    }


    @Override
    public String toString() {
    return getFamilyInfo();
    }
}