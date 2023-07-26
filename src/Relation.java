import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Relation implements IStream {
    private int id1, id2;
    private Node node;

    enum Node {
        MARIAGE, //супруги
        CHILD //ребенок
    }

    //установка связей между людьми
    public Relation(int id1, int id2, Node node) {
        setID1toID2(id1, id2, node);
    }

    void setID1toID2(int id1, int id2, Node node) {
        this.id1 = id1;
        this.id2 = id2;
        this.node = node;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    Node getNodeID1toID2() {
        return node;
    }

    //Запись данных в поток
    public void save(DataOutputStream stream_out) throws IOException {
        stream_out.writeInt(id1);
        stream_out.writeInt(id2);
        int inode = 0;
        if (node == Node.CHILD)
            inode = 1;
        stream_out.writeInt(inode);
    }

        //Чтение данных экземпляра из потока
        public void load(DataInputStream stream_in) throws IOException {
        int id1 = stream_in.readInt();
        int id2 = stream_in.readInt();
        int inode = stream_in.readInt();

        Node node = Node.MARIAGE;
        if (inode == 1)
            node = Node.CHILD;

        this.id1 = id1;
        this.id2 = id2;
        this.node = node;
    }
}