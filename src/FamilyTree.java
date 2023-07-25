import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FamilyTree {
    private boolean search;
    private List<Relation> tree = new ArrayList<>();
    private HashMap<Integer, Human> human;
    private ArrayList<Relation> relations;

    public FamilyTree() {
        human = new HashMap<>();
        relations = new ArrayList<>();
    }

    public List<Relation> getTree() {
        return tree;
    }

    public void appendParent(Human parent1, Human parent2, Human children) {
        tree.add(new Relation(parent1, Relation.Relationship.PARENT, children));
        tree.add(new Relation(parent2, Relation.Relationship.PARENT, children));
        tree.add(new Relation(children, Relation.Relationship.CHILDREN, parent1));
        tree.add(new Relation(children, Relation.Relationship.CHILDREN, parent2));
    }

    public void appendMariage(Human husband, Human wife) {
        tree.add(new Relation(husband, Relation.Relationship.MARIAGE, wife));
        tree.add(new Relation(wife, Relation.Relationship.MARIAGE, husband));
    }

    public List<Human> search(Human hum, Relation.Relationship node) {
        List<Human> result = new ArrayList<>();

        for (Relation item : tree) {
            if (item.getHuman1().equals(hum)
                    && item.getRelationship().equals(node)) {
                result.add(item.getHuman2());
            }
        }
        return result;
    }

    public void save(String file_path) {
        try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(file_path))) {
            ds.writeInt(human.size());
            for (Human h : human.values()) {
                h.save(ds);
            }
        }
    }

    public void load(String file_path) {
        try (DataInputStream ds = new DataInputStream(new FileInputStream(file_path))) {
            human.clear();
            relations.clear();
            int count = ds.readInt();
            for (int i = 0; i < count; i++) {
                Human human = new Human(0);
                human.load(ds);
                human.put(human.getId(), human);
            }

            count = ds.readInt();
            for (int i = 0; i < count; i++) {
                Relation relation = new Relation(0, 0, Type.CHILD);
                relation.load(ds);
                relations.add(relation);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
