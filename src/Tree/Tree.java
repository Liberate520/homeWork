package OOPjavaTree.src.Tree;

import OOPjavaTree.src.Person.Human;

import java.util.List;

public interface Tree extends Iterable<Human>{
    boolean add(Human human);
    List<Human> getFamilyBranches();
    Human getByName(String name);

}
