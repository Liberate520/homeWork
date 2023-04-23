import famalyTree.FamilyTree;
import famalyTree.Savable;
import humans.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Service implements Savable{
    private FamilyTree familyTree;
    private Savable savable;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        this(new FamilyTree());
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void addFamilyMember(Gender gender, String firstName, String lastName) {
        familyTree.addMember(new Human(gender, firstName, lastName));
    }

    public void getInfo(){
        familyTree.getInfo();
    }

    @Override
    public void save(FamilyTree familyTree, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(familyTree);
        } catch (Exception e) {
        }

    }

    @Override
    public FamilyTree upload(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }
    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAmountOfChildren(){
        familyTree.sortByAmountOfChildren();
    }
}
