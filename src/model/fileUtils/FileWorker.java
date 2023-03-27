package model.fileUtils;

import java.io.*;
import java.util.List;

/**
 * Класс для работы с файлами
 */
public class FileWorker {
    private String fileName;
    private String folderPath;

    public FileWorker(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFolderPath() {
        return folderPath;
    }


    public List<String> read() throws IOException {
        return FileUtils.read(folderPath + "/" + fileName);
    }

    public void create(String folderPath, String fileName) throws IOException {
        FileUtils.createFolder(folderPath);
        FileUtils.createFile(folderPath + "/" + fileName);
        this.folderPath = folderPath;
        this.fileName = fileName;
    }


    public void write(List<String> content) throws IOException {
        FileWriter fileWriter = new FileWriter(folderPath + "/" + fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String note : content) {
            bufferedWriter.write(note);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public List<String> getAllFilesNames(String extension) {
        return FileUtils.getAllFilesNames(folderPath, extension);
    }
}
