package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveLoadFileController {

    public static void SaveToFile(String filePath, String data, boolean append) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        try (FileWriter fw = new FileWriter(file, append)) {
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(data);
                bw.newLine();
            }
        }
    }

    public static String[] LoadFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        List<String> lines = new ArrayList<>();
        try (FileReader fr = new FileReader(file)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
        }

        return lines.toArray(new String[0]);
    }
}
