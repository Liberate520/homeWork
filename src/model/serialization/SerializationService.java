package model.serialization;

import model.family_tree.FamilyTree;
import model.person.Person;

public class SerializationService {
    private static final String LINK = "src/model/serialization/files/";
    public void serializationFamilyTree(FamilyTree<Person> familyTree) {
        FileHandler fileHandler = new FileHandler();
        String familyName = familyTree.getFamilyName();
        String serializationFile = LINK + familyName + "_saveFile.txt";
        fileHandler.writeObject(familyTree, serializationFile);
    }
    public FamilyTree<Person> deserializationFamilyTree(String familyName) {
        FileHandler fileHandler = new FileHandler();
        String serializationFile = LINK + familyName + "_saveFile.txt";
        return (FamilyTree) fileHandler.readObject(serializationFile);
    }
}
