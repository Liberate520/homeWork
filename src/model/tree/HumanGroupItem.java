package model.tree;

import model.human.Human;

public interface HumanGroupItem {
    String getName();

    int getId();

    Human getFather();

    Human getMother();   
    
}
