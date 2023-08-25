package com.javacourse.Family_tree;

import java.util.*;

public class CompareAge<T extends Person> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
