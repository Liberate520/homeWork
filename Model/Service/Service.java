package Model.Service;

import Model.*;
import Model.Service.writer.FileHandler;
import View.View;

import java.io.Serializable;
import java.time.LocalDate;


public class Service implements Serializable {

    private Family family;
    private FamilyMember familyMember;

    public Service() {
        family = new Family();
    }

    String filePath = "/Users/station/Desktop/HomeWork/FamilyTree/familyTree.out";
    FileHandler fileHandler = new FileHandler();
    public void saveFile() {
        fileHandler.save(family, filePath);
    }
    public Family loadFile() {
        Family familyLoad = (Family) (fileHandler.read(filePath));
        if (family != null){
        System.out.println(familyLoad.getFamilyInfo());
        family = new Family();
        family = familyLoad;
        return family; }
        return null;
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String familyStatus) {
        Human human = new Human();
        human.setName(name);
        human.setGender(gender);
        human.setAge(dateOfBirth);
        human.setDateOfDeath(dateOfDeath);
        FamilyMember familyMember = new FamilyMember();
        familyMember.addFamilyMemberStatus(familyStatus, human);
        family.addFamilyMember(familyMember);
        System.out.println(familyMember);
    }

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (FamilyMember familyMember : family) {
            stringBuilder.append(familyMember);
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        family.sortByName();
        getFamilyInfo();
    }

    public void sortByAge() {
        family.sortByAge();
        getFamilyInfo();
    }

    public FamilyMember getFamilyMember() {
        return familyMember;
    }


}