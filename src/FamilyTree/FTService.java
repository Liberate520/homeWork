package src.FamilyTree;

public class FTService {
    private FamilyTree<Person> family;
    private RW fileHandler;

    public FTService() {
        family = new FamilyTree<>();
        family.getFamilyTree();
        this.fileHandler = new FileHandler();
        }

    public void load(){
        family = (FamilyTree<Person>) fileHandler.read();

    }

    public void save(){
        fileHandler.write(family);
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

}