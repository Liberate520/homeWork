package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;


public class Human implements Serializable, TreeNode<Human> {
    private int ID; //уникальный идентификатор
    private String FIO;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human father, mother;
    private ArrayList<Human> children; //List подчеркивается красным почему-то

    private static int counter = 0;//счетчик на самом классе

    //инициализатор
    {
        ID = ++counter;
    }




    //конструкторы

    Human(){}

    //перегруженные конструкторы
    public Human(String FIO, Gender gender, LocalDate birthDate) {
        this.FIO = FIO;
        this.gender = gender;
        this.birthDate = birthDate;
    }

//    public Human(String FIO, Gender gender, LocalDate birthDate, LocalDate deathDate) {
//        this.FIO = FIO;
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//    }

//    public Human(String FIO, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father) {
//        this.FIO = FIO;
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//        this.father = father;
//    }

//    public Human(String FIO, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
//        this.FIO = FIO;
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//        this.father = father;
//        this.mother = mother;
//    }

    @Override
    public String toString(){
        if (deathDate != null){
            return "ID: " + ID + ", FIO: "  + FIO + ", gender: " + gender + ", birth date: " + birthDate + ", death date: " + deathDate;
        }
        return "ID: " + ID + ", FIO: "  + FIO + ", gender: " + gender + ", birth date: " + birthDate + ", alive";
    }



    //геттеры и сеттеры


    /**
     * Возвращает количество созданных объектов класса Human
     * @return количество созданных объектов класса
     */
    public static int getCounter() {
        return counter;
    }

    public int getID() {
        return ID;
    }

    //ID создается из счетчика класса автоматически
//    public static void setID(int ID) {
//        Human.ID = ID;
//    }

    //гражданин может менять фамилию и имя паспортном столе
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public int getAge(){
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthDate, now);
        return age;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }
}
