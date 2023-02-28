package org.example.model.comparator;

import org.example.model.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorHuman {

    public void sortTree(ArrayList<Human> bigFamily, ComparatorFunction function){
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
    }



}

