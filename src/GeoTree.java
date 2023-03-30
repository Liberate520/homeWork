import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class GeoTree implements Serializable {

    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void appendParentChild(Person parent, Person child) {
        if (parent.getGender() == Gender.Male) {
            tree.add(new Node(parent, Relation.Father, child));
        } else if (parent.getGender() == Gender.Female) {
            tree.add(new Node(parent, Relation.Mother, child));
        }
        if (child.getGender() == Gender.Male) {
            tree.add(new Node(child, Relation.Son, parent));
        } else if (child.getGender() == Gender.Female) {
            tree.add(new Node(child, Relation.Daughter, parent));
        }
    }

    public void appendWifeHusband(Person Wife, Person Husband) {
        tree.add(new Node(Wife, Relation.Wife, Husband));
        tree.add(new Node(Husband, Relation.Husband, Wife));
    }

    public void appendBrotherSister(Person Sister, Person Brother) {
        tree.add(new Node(Sister, Relation.Sister, Brother));
        tree.add(new Node(Brother, Relation.Brother, Sister));
    }

    public void appendGrand(Person person, Relation relation) {
        Person temp_1, temp_2 = null;
        for (Node item : tree) {
            if (item.p2 == person && (item.re == Relation.Father || item.re == Relation.Mother)) {
                temp_1 = item.p1;
                for (Node item2 : tree) {
                    if (item2.p2 == temp_1 && item2.re == relation) {
                        temp_2 = item.p1;
                        tree.add(new Node(temp_2, relation, person));
                    }
                }
            }
        }
        if (person.getGender() == Gender.Male) {
            tree.add(new Node(person, relation.GrandSon, temp_2));
        } else if (person.getGender() == Gender.Female) {
            tree.add(new Node(person, relation.GrandDaughter, temp_2));
        }
    }

    public void save(write saveGeo) throws IOException{
        saveGeo.write(this);
    }

    public GeoTree restore(read restoreGeo) throws IOException, ClassNotFoundException {
        return restoreGeo.read(this);
    }
}