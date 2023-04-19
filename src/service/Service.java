package service;

import human.Human;

import tree.FamilyTree;

import java.util.Scanner;


public class Service {
    private FamilyTree familyTree;
    public Service(FamilyTree familyTree){
        this.familyTree = familyTree;
    }
    public String addHuman(String name, String surname,  String bDay, String fatherName, String fatherSurname, String motherName, String motherSurname)  {
        Human humanFather = getHumanByName(fatherName,fatherSurname);
        Human humanMother = getHumanByName(fatherName,fatherSurname);

        Human human = new Human(name,surname,bDay,humanFather,humanMother);
        Human repeatHuman = familyTree.getByName(name,surname);
        if (repeatHuman!=null){
            System.out.println("Человек уже есть в дереве. Заменить Y/N?");
            Scanner scanner = new Scanner(System.in);
            if(scanner.nextLine().toLowerCase().equals("y")){
                familyTree.deleteHuman(repeatHuman);
                familyTree.addFamilyTree(human);
            }
            else{
                return "Отмена добавления";
            };
        }else {
            familyTree.addFamilyTree(human);
        };

        return "Человек добавлен";
    }
    Human getHumanByName(String name, String surname) {
        if (!name.equals("")) {
            return familyTree.getByName(name, surname);
        }
        return null;
    }
    public String getFamilyTree(){
       return familyTree.toString();
    }
    public void sortByName(){
        familyTree.sortName();
    }
    public void sortByBirthday(){
        familyTree.sortbDay();
    }
}
