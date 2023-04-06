package dzseer2.human;

import dzseer2.human.Gender_sex;
import dzseer2.human.Gender_type;

import java.io.Serializable;
public class Human implements Serializable {
    private String name;
    private String name_key;
    private String surName;
    private Gender_sex gender_sex;
    private Gender_type gender_type;
    private int data;
    private int marriage_certificate;

    public Human(String name, String surName, int data,
                 Gender_sex gender_sex, Gender_type gender_type,
                 String name_key, int marriage_certificate) {
        this.name = name;
        this.name_key = name_key;
        this.surName = surName;
        this.gender_sex = gender_sex;
        this.gender_type = gender_type;
        this.data = data;
        this.marriage_certificate = marriage_certificate;
    }
    public String getName() {return name;}
    public String getSurName() {return surName;}
    public Gender_sex getGender_sex() {return gender_sex;}
    public int getData() { return data;}
    public Gender_type getGender_type() {return gender_type;}
    public String getName_key() {return name_key;}
    public int getMarriage_certificate() {return marriage_certificate;}

    @Override
    public String toString() {
        return "Имя "+getName()+"Фимилия "+getSurName()+ "Год рождения "+getData()+" "+getGender_sex()+" "+
                (getGender_type()!=null?"("+getGender_type():"")+" "+
                (getName_key()!=null?getName_key()+")":"")+
                " - Свидетельство о браке №_"+(getMarriage_certificate()!=0?getMarriage_certificate():"no");
    }
}
