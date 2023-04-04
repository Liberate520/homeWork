package fileWork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import person.Person;

public class FilehandlerTXT {

    public static void SaveToFile(List<Person> listPerson, String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(listPerson.toString());
            System.out.printf("File " + filename + " has been written");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
