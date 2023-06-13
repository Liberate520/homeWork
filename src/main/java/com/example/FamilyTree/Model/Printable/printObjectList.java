package com.example.FamilyTree.Model.Printable;

import com.example.FamilyTree.DataForTree.FamilyInterface;
import com.example.FamilyTree.DataForTree.FamilyTree;
import com.example.FamilyTree.Model.Printable.Printable;

public class printObjectList<T extends FamilyInterface> implements Printable {
    private String print(FamilyTree<T> familyList) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (T object : familyList) {
            stringBuilder.append(index++ + ": ");
            stringBuilder.append(object.getObject());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String output(FamilyTree familyTree) {
        return print(familyTree);
    }
}
