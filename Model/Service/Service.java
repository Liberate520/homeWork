package Model.Service;

import Model.*;
import Model.Service.writer.FileHandler;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Service {

    private Family family;
    private String filePath = "/Users/station/Desktop/HomeWork/FamilyTree/familyTree.out";

    public Service () {
        family = new Family();
    }

    FileHandler fileHandler = new FileHandler();

    public void saveFile() {
        fileHandler.save(family, filePath);
    }

    public Family loadFile() {
        Family familyLoad = (Family) (fileHandler.read(filePath));
        if (family != null) {
            family = familyLoad;
            return family;
        }
        return null;
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String familyStatus) {
        Human human = new Human();
        human.setName(name);
        human.setGender(gender);
        human.setAge(dateOfBirth);
        human.setDateOfDeath(dateOfDeath);
        human.setStatus(familyStatus);
        FamilyMember familyMember = new FamilyMember();
        familyMember.addFamilyMemberStatus(familyStatus, human);
        family.addFamilyMember(familyMember);
        System.out.println(familyMember);
    }

    public FamilyMember findHuman(String name) {
        for (FamilyMember familyMember: family) {
            if (familyMember.getNameFamilyMember().equals(name)) {
                return familyMember;
            }
        }
        return null;
        //TODO return NO null
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

    public void removeFamilyMember(FamilyMember human) {
        family.removeFamilyMember(human);
    }
}
