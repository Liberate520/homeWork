package tree.interfaces;

import human.Gender;

import java.io.Serializable;
import java.util.List;

public interface TreeCreaturable<T> extends Serializable {
    int getAge();
    String getName();
    void setSpouse(T hum);
    T getSpouse();
    void addOldSpouse(T human);
    T getMother();
    T getFather();
    void addChild(T t);
    List<T> getChildrenList();
    Gender getgGender();
    void setFather(T human);
    void setMother(T human);
    String getInfo();

}
