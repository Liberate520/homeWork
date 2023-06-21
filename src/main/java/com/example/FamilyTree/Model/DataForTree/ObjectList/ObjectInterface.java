package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.Gender;

public interface ObjectInterface {
    Family getNewObject(String name, String birthday, Gender gender);
}
