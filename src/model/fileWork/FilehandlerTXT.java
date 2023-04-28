package fileWork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import group.Groupable;
import person.NodeTree;
import restorePerson.RestorePersonFromTxt;

public class FilehandlerTXT<T extends NodeTree<T>> implements Writeable<T> {

    public void SaveToFile(Groupable<T> listPerson, String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(listPerson.toString());
            System.out.printf("File " + filename + " has been written.\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Groupable<T> LoadFromFile(String filename) {
        RestorePersonFromTxt<T> rPerson = new RestorePersonFromTxt<T>();
        Groupable<T> groupList = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("]", "");
                groupList = (rPerson.restorePersonFromTxt(line));
            }
            br.close();
            System.out.println("\nFile " + filename + " has been loaded:");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return (Groupable<T>) groupList;
    }
}
