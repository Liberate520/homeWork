package FamTree;

public class NodeFamilyTree {
    public NodeFamilyTree(Human human1, Family family, Human human2){
        this.human1 = human1;
        this.family = family;
        this.human2 = human2;
    }

    Human human1;
    Family family;
    Human human2;

    @Override
    public String toString(){
        return String.format("<%s %s %s>", human1, family, human2);
    }
}
