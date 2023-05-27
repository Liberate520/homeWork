package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Family {
    List<Human> family;
    Human human;



    public void toFamily() {
        family = new ArrayList<>();
        family.add(this.human);
    }

}
