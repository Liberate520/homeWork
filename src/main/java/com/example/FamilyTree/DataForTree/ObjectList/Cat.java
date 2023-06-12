package com.example.FamilyTree.DataForTree.ObjectList;

import com.example.FamilyTree.DataForTree.FamilyInterface;
import com.example.FamilyTree.DataForTree.Gender;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cat implements Serializable, FamilyInterface {
    private String name;
    private Date birthday;
    private Gender gender;
    private int puberty = 1; // средний возврат половой зрелости

    public Cat(String name, String birt, Gender gender) {
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

    public int getPuberty() {
        return puberty;
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return name + " (birthday - " + simpDateForm.format(birthday)+"), "+((gender==Gender.female)?"сука":"кобель");
    }
}
