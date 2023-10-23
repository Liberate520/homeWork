package genealogy_tree.writer;

import genealogy_tree.genealogy_tree.GenealogyTree;

public interface Writable {
    Boolean SaveTree(GenealogyTree tree);
    GenealogyTree LoadTree();
}
