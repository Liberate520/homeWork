package model.human;

import model.human.Human;

import java.util.List;

public interface InterfaceSorted extends Iterable<Human>{
    
    
    List<Human> getHumunList();

    
    void sortedHuman();
}
