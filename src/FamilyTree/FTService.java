package src.FamilyTree;

public class FTService {
    private FamilyTree<Person> family;

    private RW fileHandler;

    public FTService() {
        family = new FamilyTree();
        this.fileHandler = new FileHandler();
        }

    public String load(){
        if(fileHandler.read() == null) {
            return "Could not read from file";
        }
        family = (FamilyTree<Person>) fileHandler.read();
        return "\nThe Family Tree is saved to sFT.ser\n";
    }

    public void save(FamilyTree family){
        fileHandler.write(this.family);
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

    public String getPersonByName(String name){
        return family.getPersonByName(name);
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