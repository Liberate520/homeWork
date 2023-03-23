package Notebook.Core.MVP.Models.FileReaderr;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderr {
    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);
        try {
            lines = Files.readAllLines(Paths.get(pathFile));
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return lines;
    }
}
    