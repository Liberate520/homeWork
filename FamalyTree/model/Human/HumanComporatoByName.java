package homeWork.FamalyTree.model.Human;

import java.util.Comparator;

import homeWork.FamalyTree.model.FamalysTree.ItemTree;

public class HumanComporatoByName <T extends ItemTree<T>> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}