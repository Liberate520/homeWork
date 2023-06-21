package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyInterface;
import com.example.FamilyTree.Model.DataForTree.Gender;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Human extends ObjectsFamilyTree implements Serializable, FamilyInterface, ObjectInterface {

    public Human(String name, String birt, Gender gender) {
        super(name, birt, gender);
        this.puberty = 15;
    }

    public Human() {
        this("","2000-01-01",Gender.male);
    }

    @Override
    public Family getNewObject(String name, String birthday, Gender gender) {
        return new Family<Human>(new Human(name,birthday,gender));
    }

    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return name + " (birthday - " + simpDateForm.format(birthday)+")";
    }
}
