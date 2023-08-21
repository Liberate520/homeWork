package workingFile;

import tree.Node;

public interface WorkingFile {
    void remove(Node ob);

    int getInd(Node ob);

    Node get(int index);

    void change(Node obOld, Node obNew);

    int getSize();
}
