package org.example.model.editing.kindred;

import org.example.model.Human;
import org.example.model.Tree;

public interface RelativesOperable{
    void addRelatives(Integer text,  Integer index, Tree<Human> tree);
    void removeRelatives();
}
