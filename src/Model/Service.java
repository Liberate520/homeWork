package Model;

import Model.FamilyTree.FamilyTree;
import Model.Human.Human;
import Model.Save.FileProcessing;
import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FileProcessing writable;
    private final String fileAddress = "tree.txt";
    private FamilyTree<Human> activeTree;

    public Service(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public Service(){
        activeTree = new FamilyTree<>();
    }

    public void save() throws IOException {
        writable.save(activeTree, fileAddress);
    }

    public FamilyTree read() throws IOException, ClassNotFoundException {
        return activeTree = (FamilyTree<Human>) writable.read(fileAddress);
    }

    public void addPerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate){
        activeTree.addHuman(new Human(firstName, lastName, birthDate, deathDate));
    }
    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByBirthday(){
        activeTree.sortByBirthday();
    }

    public String getInfo() {
        return activeTree.toString();
    }

}
