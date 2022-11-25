package DZ.DZ1;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> listHuman;

    private FamilyTree(List<Human> listHuman) {
        this.listHuman = listHuman;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getListHuman() {
        return listHuman;
    }

    public void setListHuman(List<Human> listHuman) {
        this.listHuman = listHuman;
    }

    public void addHuman(Human human) {
        listHuman.add(human);
    }

    @Override
    public String toString() {        
        //return  listHuman.toString();
        return listHuman + "";
    }
}
