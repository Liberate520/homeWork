package com.example.FamilyTree.Model.Printable;

import com.example.FamilyTree.DataForTree.FamilyInterface;
import com.example.FamilyTree.DataForTree.FamilyTree;

public interface Printable<T extends FamilyInterface> {
    String output(FamilyTree<T> familyTree);
}
