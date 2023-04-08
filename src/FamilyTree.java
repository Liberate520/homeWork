import java.util.HashSet;

public class FamilyTree implements WriterReader {
    private HashSet<Human> tree;
    

    FamilyTree() {
        this.tree = new HashSet<Human>();
    }

    void add(Human h) {
        this.tree.add(h);
    }

    

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : tree) {
            if (human.getChildrens().size() != 0) {
                result.append(human + "\n");
                if (human.getChildrens() != null) {
                    result.append("\t" + human.stringChildren() + "\n");
                }
            }
        } 
        return result.toString(); 
    }
}