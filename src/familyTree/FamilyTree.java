package familyTree;

import human.Human;
import human.ObjectComparatorByBirthday;
import human.ObjectComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem> implements Serializable, Iterable<T> {
    private int id;

    public List<T> objectList;

    public FamilyTree(){
        objectList = new ArrayList<>();
    }

    public void sortByName(){
        objectList.sort(new ObjectComparatorByName<>());
    }

    public void sortByAge(){
        objectList.sort(new ObjectComparatorByBirthday<>());
    }
    public T getByName(String name){
        for (T object: objectList){
            if (object.getName().equals(name)){
                return object;
            }
        }
        return null;
    }

    public void addObject(T object){
        if (!objectList.contains(object)){
            objectList.add(object);
            object.setId(id++);
        }
    }
    public void addMother(T object){

    }
    public void addFather(T object){

    }
//TODO убрать все проверки, позже - заменить на логирование
    public void addChild(T parent, T child){
        if (!parent.getChildren().contains(child)){
//            System.out.println("проверка два");
            parent.setChildren(child);
        }
        else System.out.println("что-то не так");
        //TODO настроить ничегонеделание, если ребёнок уже добавлен
    }//TODO добавить автоматическое добавление родителя к ребёнку по полу.
    public void getMarried(T wife, T husband ){


    }
    public String getFamilyTree(){
        StringBuilder objectStringBuilder = new StringBuilder();
        objectStringBuilder.append("Семейное древо: \n");
        for (T object: objectList){
            objectStringBuilder.append(object);
            objectStringBuilder.append("\n");
        }
        return objectStringBuilder.toString();
    }

    @Override
    public String toString() {
        return getFamilyTree().toString();
    }


    @Override//вроде так
    public Iterator<T> iterator() {
        return new ObjectIterator<>(objectList);
    }
}
