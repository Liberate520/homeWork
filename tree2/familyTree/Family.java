package homeWork.tree2.familyTree;

import homeWork.tree2.human.Human;

import java.util.ArrayList;



public interface Family extends Iterable<Human>{
    void addPeople(Human person);
}
