import java.io.*;
import java.util.List;

public class FamilyTreeFileManager implements FamilyTreeSerializable {
    private List<Person> people;

    public FamilyTreeFileManager(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public void saveFamilyTree(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(people);
        }
    }

    @Override
    public void loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            people = (List<Person>) inputStream.readObject();
        }
    }
}
