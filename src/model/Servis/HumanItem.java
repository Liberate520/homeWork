package Servis;

import java.util.List;

public interface HumanItem<T> {
    boolean addChild(T child);

    boolean addParent(T parent);

    int getAge();

    int getId();

    void setId(int id);

    List<T> getChildren();

    List<T> getParents();

    String getName();

    String getDataOfBirth();
    
    String getInfo();
}
