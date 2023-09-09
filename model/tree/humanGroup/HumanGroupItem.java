package model.tree.humanGroup;


import java.util.ArrayList;

public interface HumanGroupItem<E extends HumanGroupItem>{
    String getFullName();
    int getAge();
    ArrayList addHumans();
    String getInfo();
    String searchByName();
    ArrayList familyNode();




}
