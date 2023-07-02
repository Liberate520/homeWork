
import java.util.ArrayList;

public class Find {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public Find(HumanTree humanTree) {
        tree = humanTree.getTree();
    }

    public ArrayList<String> spend(Human p, Communication re) {
        for (Node t : tree) {
            if (t.p1.getFullName().equals(p.getFullName()) && t.re.equals(re)) {
                result.add(t.p2.getFullName());
            }
        }
        return result;
    }
}
