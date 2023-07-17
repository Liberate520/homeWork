package Homework.model.Tree;

import Homework.model.Human.Comparators.HumanComporatorByAge;
import Homework.model.Human.Comparators.HumanComporatorByName;
import Homework.model.Human.Comparators.HumanComporatorByChildren;
import Homework.model.Human.Human;
import Homework.model.Tree.Iterators.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public boolean addHuman(E human) {
        if(human == null){
            return false;
        }
        if(!familyList.contains(human)) {
            familyList.add(human);
//            familyList.setId(humansId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for(E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for(E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public E getByName(String name){
        for (E human: familyList){
            if(human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(familyList.size());
        stringBuilder.append(" объектов.\n");
        stringBuilder.append("Семья:\n");
        for (E human : familyList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void getBrotherInfo(Human human) {
        List<String> bros = new ArrayList<>();
        for (E bro : familyList) {
            if (bro.getMother() != null && bro.getMother() != null) {
                if (!bro.getName().equals(human.getName()) && (bro.getFather().equals(human.getFather()) || bro.getMother().equals(human.getMother()))) {
                    bros.add(bro.getName() + "(" + bro.getAge() + " лет)");
                }
            }
        }

        if (bros.isEmpty()) {
            System.out.println("Извините! Данных о братьях/сестрах " + human.getName() + " нет!");
        } else {
            System.out.println("Братья/сестры " + human.getName() + ":");
            for (String br : bros) {
                System.out.println("- " + br);
            }
        }
    }

    public void sortByName(){
        familyList.sort(new HumanComporatorByName());
    }

    public void sortByAge(){
        familyList.sort(new HumanComporatorByAge());
    }

    public void sortByChildren(){
        familyList.sort(new HumanComporatorByChildren());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyList);
    }

}
