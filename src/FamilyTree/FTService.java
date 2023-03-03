package src.FamilyTree;

public class FTService {
    private FamilyTree<Person> family;
    private RW fileHandler;

    public FTService() {
        family = new FamilyTree<>();
        this.fileHandler = new FileHandler();
        }

    public void load(){
        family = (FamilyTree<Person>) fileHandler.read();

    }

    public void save(){
        fileHandler.write(family);
    }


    public String PrintingListOfPersons(){
        return family.sortByBirthday();
    }

    public String YearsOfTheReignOfPersons() {
        return family.sortByYearOfReigh();
    }

}