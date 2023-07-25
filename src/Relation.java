import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
public class Relation implements IStream {
    private Human human1;
    private Human human2;
    private Relationship node;

    enum Relationship {
        PARENT,
        CHILDREN,
        MARIAGE
    }

    public Relation(Human human1, Relationship node, Human human2) {
        this.human1 = human1;
        this.node = node;
        this.human2 = human2;
    }

    public Human getHuman1() {
        return human1;
    }

    public Human getHuman2() {
        return human2;
    }

    public Relationship getRelationship() {
        return node;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", human1, node, human2);
    }

    @Override
    public void save(DataOutputStream stream_out) throws IOException {
        stream_out.writeInt(human1);
        stream_out.writeInt(human2);
        int itype = 0;
        if (node == node.CHILDREN)
            itype = 1;
        stream_out.writeInt(itype);
    }

    @Override
    public void load(DataInputStream stream_in) throws IOException {
        int id1 = stream_in.readInt();
        int id2 = stream_in.readInt();
        int itype = stream_in.readInt();

        Type type = Type.SPOUSES;
        if (itype == 1)
            type = Type.CHILD;

        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }


}