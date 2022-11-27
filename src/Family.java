import java.util.ArrayList;
import java.util.List;

public class Family {
    private Man father;
    private Woman mother;
    private List<Human> children;

    public Family(Man father, Woman mother, List<Human> children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Family(Man father, Woman mother) {
        this(father, mother, new ArrayList<Human>());
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getSons() {
        List<Human> sons = new ArrayList<Human>();
        for (Human child : children) {
            if (child.getSex() == CONST.Sex.MAN) {
                sons.add((Human) child);
            }
        }
        return sons;
    }

    public List<Human> getDaughters() {
        List<Human> daughters = new ArrayList<Human>();
        for (Human child : children) {
            if (child.getSex() == CONST.Sex.WOMAN) {
                daughters.add((Human) child);
            }
        }
        return daughters;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }
}
