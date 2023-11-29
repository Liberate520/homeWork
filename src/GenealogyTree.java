import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GenealogyTree implements FileWritableReadable {
    private Map<String, Person> people;

    public GenealogyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(String key, Person person) {
        people.put(key, person);
    }

    public Person getPerson(String key) {
        return people.get(key);
    }

    public void addChild(String parentKey, String childKey) {
        Person parent = people.get(parentKey);
        Person child = people.get(childKey);
        if (parent != null && child != null) {
            parent.addChild(child);
            if (child.getGender().equals("male")) {
                child.setFather(parent);
            } else {
                child.setMother(parent);
            }
        }
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
        }
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            this.people = (Map<String, Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
