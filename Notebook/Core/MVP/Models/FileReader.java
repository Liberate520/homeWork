package Notebook.Core.MVP.Models;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Notebook.Core.Models.Recording;

public class FileReader {
    public static List<Recording> read(String path) {
        List<Recording> recordings = new ArrayList<>();
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);
        try {
            List<String> list = Files.readAllLines(Paths.get(pathFile));
            for (String string : list) {
                string = (string.replace("{", "")
                        .replace("}", "")
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("\"", ""))
                        .trim();
                String[] temp = string.split(":");
                recordings.add(new Recording(temp[0], temp[1]));                
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return recordings;
    }
}
