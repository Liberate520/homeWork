package tree.interfaces;

import java.util.List;

import tree.classes.Human;

public interface iTree {

    List<Human> getTree();

    void addPerson(Human person);

}