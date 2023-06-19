package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.FamilyInterface;
import com.example.FamilyTree.Model.DataForTree.Gender;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human extends ObjectsFamilyTree implements Serializable, FamilyInterface {

    public Human(String name, String birt, Gender gender) {
        super(name, birt, gender);
        this.puberty = 15;
    }

    @Override
    public List getListFields(){
        return new ArrayList<>(Arrays.asList("name", "birthday", "gender", "parents", "children"));
    }

    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return name + " (birthday - " + simpDateForm.format(birthday)+")";
    }
}
