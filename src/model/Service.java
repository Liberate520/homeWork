package model;

import java.time.LocalDate;

public class Service {
    FamilyTree<Human> familyList;

    public Service(){
        familyList= new FamilyTree();

    }

    public void addFamily(String name, Gender gender, Human Father, Human Mather, Human children, LocalDate birthday, LocalDate deathday){
        Human member = new Human(name, gender, Father, Mather, children, birthday, deathday);
        familyList.familyAdd(member);
    }


    public void addFamily(String name, Gender gender, LocalDate birthday,LocalDate deathday){
        Human member = new Human(name, gender, birthday, deathday);
        familyList.familyAdd(member);
    }




    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семьи: \n");

        for (Object members : familyList) {
            stringBuilder.append(members);

        }
        return stringBuilder.toString();
    }

    public  void sortByName(){
        familyList.sortByName();
    }

    public  void sortByAge(){
        familyList.sortByAge();
    }






}
