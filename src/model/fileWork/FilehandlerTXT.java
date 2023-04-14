package model.fileWork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.group.Groupable;
import model.person.NodeTree;

public class FilehandlerTXT<T extends NodeTree<T>> implements Writeable<T> {

    public void SaveToFile(Groupable<T> listPerson, String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(listPerson.toString());

            System.out.printf("File " + filename + " has been written");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Groupable<T> LoadFromFile(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LoadFromFile'");
    }


}
