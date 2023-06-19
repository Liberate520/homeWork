package com.example.FamilyTree.Model.Printable;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyInterface;

import java.util.List;

public interface Printable<T extends Family & FamilyInterface> {
    String output(List<T> familyTree);
}
