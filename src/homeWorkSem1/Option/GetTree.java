package homeWorkSem1.Option;

import java.io.Serializable;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class GetTree <T extends Human> implements Serializable, Option{

    @Override
    public void execute(FamilyTree<Human> tree) {
        System.out.println(tree);
        
    }

    @Override
    public String description() {
        return String.format("Get FamilyTree");
    }
    
}
