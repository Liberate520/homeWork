package homeWorkSem1.Option;

import java.io.Serializable;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class GetTree implements Serializable, Option{

    @Override
    public String description() {
        return String.format("Get FamilyTree");
    }

    @Override
    public void exucute(FamilyTree<Human> tree) {
        System.out.println(tree);
    }    
}
