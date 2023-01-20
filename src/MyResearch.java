import java.util.ArrayList;

public class MyResearch implements IIResearch {

    ArrayList<Nodes> tree;

    public MyResearch(Trees pd) {
        tree = pd.getData();
    }

    @Override
    public ArrayList<Persons> spend(Humans p, Relationships re) {

        var result = new ArrayList<Persons>();
        for (Nodes t : tree) {
            if (t.p1.getName() == p.getName() && t.relation == re) {
                result.add(t.p2);

            }

        }

        return result;
    }

}
