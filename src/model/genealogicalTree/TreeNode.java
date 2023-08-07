package model.genealogicalTree;

import java.time.LocalDate;

public interface TreeNode {

    String getInfo();


    LocalDate getBirth();
    int showAge();

    String getName();
    String getLastName();


}
