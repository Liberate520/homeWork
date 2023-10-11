package serialization;

import family_tree.FamilyTree;
import person.Person;

public class SerializationService {
    public void serializationFamilyTree(FamilyTree<Person> familyTree) {
        FileHandler fileHandler = new FileHandler();
        String serializationFile = "src/serialization/saveFile.txt";
        fileHandler.writeObject(familyTree, serializationFile);
    }
    public FamilyTree<Person> deserializationFamilyTree() {
        FileHandler fileHandler = new FileHandler();
        String serializationFile = "src/serialization/saveFile.txt";
        return (FamilyTree) fileHandler.readObject(serializationFile);
    }
}
