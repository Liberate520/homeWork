package homeWork.filehandling;

import homeWork.familytree.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeFileHandler implements FileHandler {

    @Override
    public void writeToFile(List<Human> humans, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(humans);
            System.out.println("Family tree data written to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            throw e; // Rethrow the exception to the calling code
        }
    }

    @Override
    public List<Human> readFromFile(String filename) throws IOException {
        List<Human> humans = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            humans = (List<Human>) ois.readObject();
            System.out.println("Family tree data read from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            throw e; // Rethrow the exception to the calling code
        }
        return humans;
    }
}








