package com.example.FamilyTree.Model.Printable;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyInterface;

import java.util.List;

public class printObjectList<T extends Family & FamilyInterface> implements Printable {
    private String print(List<T> familyList) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (T object : familyList) {
            stringBuilder.append("\n");
            stringBuilder.append(index++ + ": ");
            stringBuilder.append(object.getObject());
        }
        return stringBuilder.toString();
    }

    @Override
    public String output(List familyTree) {
        return print(familyTree);
    }
}
