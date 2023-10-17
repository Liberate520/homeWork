package model.saving;

import model.family_tree.FamilyTree;
import model.person.Person;
import model.saving.serialization.FileHandler;

public class SerializationSave implements Saving {
    private static final String LINK = "src/model/saving/files/";
    private static final String SAVE_FILE_NAME = "_saveFile.txt";
    public void save(FamilyTree<Person> familyTree) {
        FileHandler fileHandler = new FileHandler();
        String familyName = familyTree.getFamilyName();
        String serializationFile = LINK + familyName + SAVE_FILE_NAME;
        fileHandler.writeObject(familyTree, serializationFile);
    }
    public FamilyTree<Person> download(String fileName) {
        FileHandler fileHandler = new FileHandler();
        String serializationFile = LINK + fileName + SAVE_FILE_NAME;
        return (FamilyTree) fileHandler.readObject(serializationFile);
    }
}
