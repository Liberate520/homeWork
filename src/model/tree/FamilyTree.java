package model.tree;

import model.Person;
import model.comparators.PersonComparatorByAge;
import model.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeItem> implements Serializable, Iterable<T>{

    private List<T> humanList;

    public FamilyTree(List<T> human) {
        this.humanList = human;
    }

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHumanList(T human) {
        humanList.add(human);
    }


//    public String getHumanListInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Список всех людей: \n");
//        stringBuilder.append("\n");
//        for (Human Model.human : humanList) {
//            stringBuilder.append(Model.human);
//            stringBuilder.append("\n");
//        }
//        stringBuilder.append("=".repeat(50));
//        return stringBuilder.toString();
//    }




    /**
     * Поиск человека по имени
     *
     * @param name
     * @return
     */
    public String findPerson(String name) {
        System.out.println("Введите имя для поиска: ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей с именем " + name);
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        for (T human : humanList) {
            if (human.getFirstName().equalsIgnoreCase(name.toLowerCase())) {
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        Collections.sort(humanList, new PersonComparatorByName<>());
    }

    public void sortByAge(){
        Collections.sort(humanList, new PersonComparatorByAge<>());
    }
    public int humanListSize(){
        return humanList.size();
    }
    public T getPersonById (int id){
        return humanList.get(id);
    }
}
