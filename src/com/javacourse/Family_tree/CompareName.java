package com.javacourse.Family_tree;

import java.util.*;

public class CompareName<T extends Person> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2){
        return o1.getName().compareTo(o2.getName());
    }
}
