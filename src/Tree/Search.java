package Tree;

import java.util.ArrayList;

class Search {
    ArrayList<Node> tree;

    public Search(Tree pd) {
        tree = pd.getData();
    }

    public ArrayList<Person> spend(Human p, Human.link re) {
        var result = new ArrayList<Person>();
        for (Node t : tree) {
            if (t.p1.getName() == p.getName() && t.re == re) {
                result.add(t.p2);
            }
        }
        return result;
    }

}
