package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.FamilyInterface;
import com.example.FamilyTree.Model.DataForTree.Gender;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class ObjectsFamilyTree implements Serializable, FamilyInterface {
    protected String name;
    protected Date birthday;
    protected Gender gender;
    protected int puberty; // средний возраст половой зрелости

    public ObjectsFamilyTree(String name, String birt, Gender gender) {
        this.name = name;
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birt, new ParsePosition(0));
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public Object getObject() {
        return this;
    }
    public int getPuberty() {
        return puberty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List getListFields(){
        return new ArrayList<>(Arrays.asList("name", "birthday", "gender", "parents", "children"));
    }
}
