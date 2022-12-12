import java.util.ArrayList;

interface Tree {
    void append(Person parent, Link v1, Link v2, Person children);

    ArrayList<Node> getData();
}