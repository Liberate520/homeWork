package FileWork;

import java.io.FileWriter;
import java.io.IOException;

import Group.Group;

public class FilehandlerTXT extends Filehahdler {

    public static void SaveToFile(Group group, String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(group.toString());
            System.out.printf("File " + filename + " has been written");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
