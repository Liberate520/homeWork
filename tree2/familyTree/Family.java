package homeWork.tree2.familyTree;

import homeWork.tree2.human.Human;
import homeWork.tree2.human.HumanObjectInterface;

import java.util.ArrayList;



public interface Family<E extends HumanObjectInterface> extends Iterable<E>{
    void addPeople(E person);
}
