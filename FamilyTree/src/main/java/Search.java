import java.util.ArrayList;

class Search {
    private static ArrayList<Node> tree;

    public Search(ArrayList<Node> tree) {
        this.tree = tree;
    }


    public static ArrayList<Person> spend(Person p, Link re) {
        var result = new ArrayList<Person>();
        for (Node t : tree) {
            if (t.p1.getName() == p.getName() && t.re == re) {
                result.add(t.p2);
            }
        }
        return result;
    }

}