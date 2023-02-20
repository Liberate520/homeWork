package org.example;

import org.example.Iterator.HumanIterator;
import org.example.comparator.ComparatorFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Tree  implements Iterable<Human>{
    private final ArrayList <String> existingIds;  // хранит существующие id Human (для того, чтобы при загрузке файла
    {
        existingIds = new ArrayList<>();
    }
    private String nameFamily;
    private final ArrayList<Human> bigFamily;
    {
        bigFamily = new ArrayList<>();
    }


    public String getNameFamily() {
        return nameFamily;
    }

    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    public ArrayList<Human> getBigFamily() {
        return bigFamily;
    }

    public ArrayList<String> getExistingIds() {
        return existingIds;
    }

    public void addHuman(Human human){
        this.bigFamily.add(human);
        this.existingIds.add(bigFamily.get(bigFamily.size() - 1).getId());
    }

    public void removingAPerson(ArrayList<Human> bigFamily, int index){
        bigFamily.remove(index);
    }



    public void sortTree(ComparatorFunction function){
        if (function.equals(ComparatorFunction.name)){
            bigFamily.sort(new Comparator<Human>() {
                @Override
                public int compare(Human o1, Human o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }else if (function.equals(ComparatorFunction.id)){
            bigFamily.sort(new Comparator<Human>() {
                @Override
                public int compare(Human o1, Human o2) {
                    int a = Integer.parseInt(new ArrayList<>(Arrays.asList(o1.getId().split(":"))).get(1));
                    int b = Integer.parseInt(new ArrayList<>(Arrays.asList(o2.getId().split(":"))).get(1));
                    return Integer.compare(a, b);

                            //o1.getId().compareTo(o2.getId());
                }
            });
        } else if (function.equals(ComparatorFunction.dateOfBirth)){
            bigFamily.sort(new Comparator<Human>() {
                @Override
                public int compare(Human o1, Human o2) {
                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                }
            });
        }


        //else if (function.equals(ComparatorFunction.dateOfBirth)){
            //    bigFamily.sort(Comparator.comparing(Human::getDateOfBirth));
            //}
         //this.bigFamily.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        //arrayList.sort(Comparator.comparing(Human::getName).thenComparing(Human::getName));
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(bigFamily);
    }
}


