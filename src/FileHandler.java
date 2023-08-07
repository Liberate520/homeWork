import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements FileIO{
    @Override
    public void writeToFile(List<Person> people, String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(people);
            System.out.println("Data written to " + filename);
        }
    }

    @Override
    public List<Person> readFromFile(String filename) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            List<Person> people = (List<Person>) inputStream.readObject();
            System.out.println("Data read from " + filename);
            return people;
        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
