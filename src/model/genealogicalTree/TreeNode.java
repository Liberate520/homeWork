package model.genealogicalTree;

import model.human.Human;

import java.time.LocalDate;

public interface TreeNode {

    String getInfo();
    LocalDate getBirth();
    int showAge();
    void setSpouse(Human human);
    String getName();
    String getLastName();
    int getID();

}
