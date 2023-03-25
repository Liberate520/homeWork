package notebook.core.mvp.models.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import notebook.core.essence.Recording;

import java.util.Iterator;

public class TextFileHandler implements FileHandler {

    @Override
    public List<Recording> read(String path) throws IOException {
        List<Recording> recordings = new ArrayList<>();
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathFile));
            for (String string : lines) {
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
        } catch (IOException e) {
            throw new IOException("Failed to read file.", e);
        }
        return recordings;
    }

    @Override
    public void write(String path, Iterable<Recording> iterable) throws IOException {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);
        File file = new File(pathFile);

        try (FileWriter fileWriter = new FileWriter(file)) {
            Iterator<Recording> iterator = iterable.iterator();
            fileWriter.write("[");
            while (iterator.hasNext()) {
                Recording recording = iterator.next();
                
                String formattedRecording = JsonFormatter.toJson(recording);
                fileWriter.write(formattedRecording);
                if (iterator.hasNext()) {
                    fileWriter.write(",\n");
                }
            }
            fileWriter.write("]");
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            throw new IOException("Failed to write to file.", e);
        }
    }    
}
