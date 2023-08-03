import java.util.ArrayList;

 public class Research extends Family_tree {
    
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    protected Research(Family_tree geoTree) {
        tree = geoTree.getTree();
    }

    // метод поиска связи: родитель - ребенок
    public ArrayList<String> spend(Person p, Relationship re) {
        for (Node t : tree) {
            if (t.p1.firstname == p.firstname && t.re == re) {
                result.add(t.p2.firstname);
            }
        }
        return result;
    }
}
