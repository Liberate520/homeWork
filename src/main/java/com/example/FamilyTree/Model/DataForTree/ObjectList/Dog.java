package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyInterface;
import com.example.FamilyTree.Model.DataForTree.Gender;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Dog extends ObjectsFamilyTree implements Serializable, FamilyInterface, ObjectInterface {

    public Dog(String name, String birt, Gender gender) {
        super(name,birt,gender);
        this.puberty = 2;
    }

    public Dog() {
        this("","2000-01-01",Gender.male);
    }

    @Override
    public Family getNewObject(String name, String birthday, Gender gender) {
        return new Family<Dog>(new Dog(name,birthday,gender));
    }

    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return name + " (birthday - " + simpDateForm.format(birthday)+"), "+((gender==Gender.female)?"сука":"кобель");
    }
}
