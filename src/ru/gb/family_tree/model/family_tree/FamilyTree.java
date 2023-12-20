package ru.gb.family_tree.model.family_tree;
import model.creatures.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Creature<T>> implements Iterable<T>, Serializable {
    //TODO: Можно сделать в одном экземпляре
    private final List<T> familyTree;
    private final List<T> notInTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
        this.notInTree = new ArrayList<>();
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    public List<T> getNotInTree() {
        return notInTree;
    }

    public T getFirstMember() {
        return familyTree.getFirst();
    }

    public boolean setSpouse(T firstSpouce, T secondSpouce) {
        if (firstSpouce.getSpouse() == null && secondSpouce.getSpouse() == null) {
            firstSpouce.setSpouse(secondSpouce);
            secondSpouce.setSpouse(firstSpouce);
        } else {
            return false;
        }
        if (!firstSpouce.isInTree()) {
            familyTree.add(firstSpouce);
            firstSpouce.setInTree();
            notInTree.remove(firstSpouce);
        }
        if (!secondSpouce.isInTree()) {
            familyTree.add(secondSpouce);
            secondSpouce.setInTree();
            notInTree.remove(secondSpouce);
        }
        return true;
    }

    public boolean divorce(T firstSpouce, T secondSpouce) {
        return firstSpouce.equals(secondSpouce.getSpouse()) && firstSpouce.setSpouse(null)
                && secondSpouce.setSpouse(null);
    }

    public boolean setMother(T child, T mother) {
        child.setMother(mother);
        if (!child.isInTree()) {
            familyTree.add(child);
            child.setInTree();
            notInTree.remove(child);
        }
        if (!mother.isInTree()) {
            familyTree.add(mother);
            mother.setInTree();
            notInTree.remove(mother);
        }
        if (mother.getChildren() != null && mother.getChildren().contains(child)) {
            return false;
        } else {
            mother.setChildren(child);
            return true;
        }
    }

    public boolean setChildren(T parent, T child) {
        if (!child.isInTree()) {
            familyTree.add(child);
            child.setInTree();
            notInTree.remove(child);
        }
        if (!parent.isInTree()) {
            familyTree.add(parent);
            parent.setInTree();
            notInTree.remove(parent);
        }
        if (parent.getChildren() != null && parent.getChildren().contains(child)) {
            return false;
        } else {
            parent.setChildren(child);
            return true;
        }
    }

    public boolean setFather(T child, T father) {
        child.setFather(father);
        if (!child.isInTree()) {
            familyTree.add(child);
            child.setInTree();
            notInTree.remove(child);
        }
        if (!father.isInTree()) {
            familyTree.add(father);
            father.setInTree();
            notInTree.remove(father);
        }
        if (father.getChildren() != null && father.getChildren().contains(child)) {
            return false;
        } else {
            father.setChildren(child);
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Члены данной семьи: \n");
        for (T human : familyTree) {
            sb.append(human.getName()).append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        familyTree.sort(new CreatureComporatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new CreatureComporatorByAge());
    }

    public void sortByID() {
        familyTree.sort(new CreatureComporatorById());
    }

    public T searchById(Integer id) {
        familyTree.sort(new CreatureComporatorById());
        notInTree.sort(new CreatureComporatorById());
        int finalId = Collections.binarySearch(familyTree,
                new Human(id, null, null, null, null),
                new CreatureComporatorById());
        if (finalId >= 0) {
            return familyTree.get(finalId);
        } else {
            finalId = Collections.binarySearch(notInTree,
                    new Human(id, null, null, null, null),
                    new CreatureComporatorById());
            if (finalId >= 0) {
                return notInTree.get(finalId);
            }

        }
        return null;
    }

    public boolean addCreature(T creature) {
        if (getNotInTree().contains(creature) || familyTree.contains(creature)) {
            return false;
        } else {
            getNotInTree().add(creature);
            return true;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<T>(familyTree);
    }

    public boolean emptyCheck() {
        if (familyTree.isEmpty())
            return false;
        else {
            return true;
        }
    }
}


//import ru.gb.family_tree.human.Gender;
//import ru.gb.family_tree.human.Human;
//import ru.gb.family_tree.model.TreeNode;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Iterator;
//
//public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
//    private List<E> familyTreeList;
//
//    //конструктор
//    public FamilyTree(){
//        familyTreeList = new ArrayList<>(); //не позволяет сделать просто List - подчеркивает красным
//    }
//
//    //добавление человека
//    public void addHuman(E human){
//        familyTreeList.add(human);
//    }
//
//    //добавление ребенка для человека
//
//    //выдача человека по ID
//    public Human getHumanByID(int ID){
//        for (E human : familyTreeList) {
//            if (human.getID() == ID) {
//                return human;
//            }
//        }
//        return null;
//    }
//
//    //выдача человека по ФИО
//    public Human getHumanByFIO(String fio){
//        for (Human human : familyTreeList) {
//            if (human.getFIO().equals(fio)){
//                return human;
//            }
//        }
//        return null;
//    }
//
//    //проверка на то кем является человек - сыном или дочерью
//    public String getDescendant(Human human){
//        if (human.getGender().equals(Gender.Male)){
//            return "son";
//        }
//        return "daughter";
//    }
//
//    //выдача человека со всеми детьми
//    public String getChildren(Human parent){
//        StringBuilder stringBuilder = new StringBuilder();
//        //stringBuilder.append(parent);
//        //stringBuilder.append("\n\t дети: ");
//        for (Human human : familyTreeList) {
//            //if ((human.getMother().equals(parent)) || (human.getFather().equals(parent))){
//            if (((human.getMother() != null) && (human.getMother().equals(parent))) ||
//            ((human.getFather() != null) && (human.getFather().equals(parent))))
//            {
//                stringBuilder.append("\n\t" + getDescendant(human) + " " + human.getFIO() + " (ID " + human.getID() + ")");
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    //выдача списка всех людей
//    public String getFamilyTree(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("=== Family tree ===\n");
//        for (Human human : familyTreeList){
//            stringBuilder.append(human);
//            stringBuilder.append(getChildren(human));
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    @Override
//    public String toString(){
//        return getFamilyTree();
//    }
//
//    @Override
//    public Iterator<Human> iterator(){
//        HumanIterator humanIterator = new HumanIterator(familyTreeList);
//        return humanIterator;
//    }
//
//    public void sortByName(){
//        familyTreeList.sort(new HumanComparatorByName());
//    }
//
//    public void sortByBirthDate(){
//        familyTreeList.sort(new HumanComparatorByBirthDate());
//    }
//
//
//
//}
