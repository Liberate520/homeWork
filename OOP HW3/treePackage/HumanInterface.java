package treePackage;

import java.util.List;

public interface HumanInterface extends Iterable<Human> {

    
    Object humanForSort = null;

    List<Human> getHumanList();
    
    void addHumanForSort(Human human);

}
