package model.fileWork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.group.Groupable;
import model.human.NodeTree;
import model.restoreHuman.RestoreHumanFromTxt;

public class FilehandlerTXT<T extends NodeTree<T>> implements Writeable<T> {

    public void SaveToFile(Groupable<T> listHuman, String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(listHuman.toString());
            System.out.printf("File " + filename + " has been written.\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Groupable<T> LoadFromFile(String filename) {
        RestoreHumanFromTxt<T> human = new RestoreHumanFromTxt<T>();
        Groupable<T> groupList = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("]", "");
                groupList = (human.restoreHumanFromTxt(line));
            }
            br.close();
            System.out.println("\nFile " + filename + " has been loaded:");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return (Groupable<T>) groupList;
    }
}
