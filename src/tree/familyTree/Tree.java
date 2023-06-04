package tree.familyTree;

import tree.human.Human;

import java.util.List;

public interface Tree extends Iterable<Human>{
    void setFamily(Human human);
    List<Human> getFamilyTree();
}
