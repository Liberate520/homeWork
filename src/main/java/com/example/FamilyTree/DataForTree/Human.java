package com.example.FamilyTree.DataForTree;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human implements Serializable {
    private String name;
    private Date birthday;
    private Gender gender;

    public Human(String name, String birt, Gender gender) {
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
    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return name + " (birthday - " + simpDateForm.format(birthday)+")";
    }


}
