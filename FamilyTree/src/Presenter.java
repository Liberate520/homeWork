import java.util.Collections;

public class Presenter <T extends Person> {

    private FamilyTree myFamilyTree;

    public Presenter(FamilyTree myFamilyTree) {
        this.myFamilyTree = myFamilyTree;
    }


    public void setMyFamilyTree(FamilyTree myFamilyTree) {
        this.myFamilyTree = myFamilyTree;
    }

    public void saveMyFamilyTree() {
        myFamilyTree.save();
    }

    public void printMyFamilyTree() {
        System.out.println(myFamilyTree.getAllPersons());
    }

    public void addNewPerson(T newPerson) {
        myFamilyTree.addPerson(newPerson);
    }

    public T findPerson(String str) {
        return (T) myFamilyTree.getPersonByName(str);
    }


    public FamilyTree sortByName(String sortParameter) {
        myFamilyTree.sortByName();
        return myFamilyTree;
    }

    public FamilyTree sortByAge(String sortParameter) {
        myFamilyTree.sortByAge();
        return myFamilyTree;
    }

}
