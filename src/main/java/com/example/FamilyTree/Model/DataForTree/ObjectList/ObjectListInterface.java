package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyTree;
import com.example.FamilyTree.Model.DataForTree.Gender;

import java.util.List;

public interface ObjectListInterface {
    List<String> getObjectList();
    Family getNewObject(int object, String name, String birthday, Gender gender);
    FamilyTree<Family> getFamilyTree(int object);
}
