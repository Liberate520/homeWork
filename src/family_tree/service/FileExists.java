package family_tree.service;

import java.io.File;

public class FileExists {
    private String filePath;

    public boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.isFile();
    }
}
