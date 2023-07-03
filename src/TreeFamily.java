import java.util.ArrayList;

public class TreeFamily {
    private ArrayList<Connect> treeFamily = new ArrayList<>();

    public ArrayList<Connect> getTree() {
        return treeFamily;
    }

    public void addMomForChildren(Human mom, Human children) {
        treeFamily.add(new Connect(mom, Communication.mother, children));
        treeFamily.add(new Connect(children, Communication.children, mom));
    }

    public void addDadForChildren(Human dad, Human children) {
        treeFamily.add(new Connect(dad, Communication.father, children));
        treeFamily.add(new Connect(children, Communication.children, dad));
    }

    public void addWifeAndHusband(Human wife, Human husband) {
        treeFamily.add(new Connect(wife, Communication.wife, husband));
        treeFamily.add(new Connect(husband, Communication.husband, wife));
    }


}