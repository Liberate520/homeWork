package model.group;

import java.util.List;

public interface Groupable<T> extends Iterable<T>{

    void addHuman(T t);
    List<T> getHumanList();
    T getHumanByName(String name);
    void findHuman(String name);
    void sortByName(); 
    void sortByAge();
    void sortById();
    void sortByGenderd();
    }
