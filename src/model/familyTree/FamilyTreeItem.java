package model.familyTree;

import model.human.gender.Gender;

import java.time.LocalDate;
import java.util.List;

public  interface FamilyTreeItem<T> {
    int getAge();
    String getName();
    String getGender();
    LocalDate getBirthDay();
    void setId(int id);

    default void setChildren(T children){};
    List<T> getChildren();

    //Вопрос: а как в интерфейсе прописывать методы с параметрами, как ниже?

    T getMother();
    default void setMother(T mother){};

    //??? А как, собственно, прописывать методы, которые не void?
    default String getGender(T human){
        return getGender();
    };
//    public T getFather();
//
    default void setFather(T father){};


}
