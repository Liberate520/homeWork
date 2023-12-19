package model.tree;

import model.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public interface TreeNode<T> extends Serializable {
    void setId(int id);
    int getId();
    String getLastname();
    String getName();
    int age();
    Gender getGender();
    LocalDate getBirthday();
    String getAge();
    String getSpouse();

    String getChildren();
    String getParents();

}
