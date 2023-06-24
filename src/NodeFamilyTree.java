public class NodeFamilyTree {
    public NodeFamilyTree(Human h1, Family family, Human h2){
        this.h1 = h1;
        this.family = family;
        this.h2 = h2;
    }

    Human h1;
    Family family;
    Human h2;

    @Override
    public String toString(){
        return String.format("<%s %s %s>", h1, family, h2);
    }
}
