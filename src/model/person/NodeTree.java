package model.person;

import java.util.List;

/**
 * GroupInterface
 */
public interface NodeTree<T> {

    String getName();

    T getMother();

    T getFather();

    int getAge();

    int getId();

    Gender getGender();

    void addChild(T t);

    List<T> getChildrens();


}
