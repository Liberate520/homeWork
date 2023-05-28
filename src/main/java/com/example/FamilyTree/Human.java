package com.example.FamilyTree;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    private String name;
    private Date birthday;
    private Gender gender;

    public Human(String name, String birt, Gender gender) {
        this.name = name;
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birt, new ParsePosition(0));
        this.gender = gender;
    }

    public Human(){
        this("Name human", "2023-01-01", Gender.male);
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return "\n name = '" + name + '\'' +
                ", birthday = " + simpDateForm.format(birthday);/* +
                ", gender = " + gender.name();*/
    }
}
