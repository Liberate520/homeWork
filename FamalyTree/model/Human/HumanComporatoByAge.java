package homeWork.FamalyTree.model.Human;

import java.util.Comparator;

import homeWork.FamalyTree.model.FamalysTree.ItemTree;

public class HumanComporatoByAge<T extends ItemTree<T>> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
    
}
