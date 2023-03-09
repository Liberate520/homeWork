package src.FamilyTree;

import src.SaveRestore.FileHandlerR;
import src.SaveRestore.FileHandlerW;
import src.SaveRestore.Read;
import src.SaveRestore.Write;

public class FTService {
    private FamilyTree<Person> family;

    private Read fileHandlerR;
    private Write fileHandlerW;

    public FTService() {
        family = new FamilyTree();
        this.fileHandlerR = (Read) new FileHandlerR();
        this.fileHandlerW = (Write) new FileHandlerW();
        }

    public String load(){
        if(fileHandlerR.read() == null) {
            return "Could not read from file";
        }
        family = (FamilyTree<Person>) fileHandlerR.read();
        return "\nThe Family Tree is saved to sFT.ser\n";
    }

    public void save(FamilyTree family){
        fileHandlerW.write(this.family);
    }

    public String printingListOfPersons(){
        return family.sortByBirthday();
    }

    public String yearsOfTheReignOfPersons() {
        return family.sortByYearOfReigh();
    }

    public String findSpouse(String name) {
        return family.findSpouse(name);
    }

    public String findParents(String name) {
        return family.findParents(name);
    }

    public String getPersonByName(String name){
        return family.getPersonByName(name);
    }

    public String remotePerson(String name){
        return family.remotePerson(name);
    }

    public boolean addPersonToTree(String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        return family.addPersonToTree( name,  birthDay,  deathDay, sex, additionalField);
    }

    public boolean addWifeToHusband(String husbandName, String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField){
        return family.addWifeToHusband( husbandName, name,  birthDay,  deathDay, sex, additionalField);
    }

    public boolean addChildToMother(String motherName, String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        family.addChildToMother( motherName, name, birthDay, deathDay, sex, additionalField);
        return true;
    }
}