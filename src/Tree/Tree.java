package Tree;

import java.util.ArrayList;;

interface Tree {
    void append(Person parent, Human.link v1, Human.link v2, Person children);

    ArrayList<Node> getData();
}