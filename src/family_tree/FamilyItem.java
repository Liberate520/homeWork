package family_tree;

import human.Gender;

import java.io.Serializable;

public interface FamilyItem<T> extends Serializable {
    String getName();
    int getAge();

    void setId(long l);

    long getId();

    Gender getGender();

    String getChild();
}
