package model.fileUtils;

import java.io.IOException;
import java.util.List;

public interface FileInterface {
    // Открыть файл по указанному пути
    void open(String folderPath, String fileName) throws IOException;

    // Проверить, открыт ли файл
    boolean isOpened();

    // Прочитать содержимое файла
    List<String> read() throws IOException;

    // Создать новый файл по указанному пути с указанным именем и расширением
    void createFile(String folderPath, String fileName, String extension) throws IOException;

    // Сохранить содержимое в открытый файл
    void save(List<String> content) throws IOException;

    // Получить список имен всех файлов в указанной папке с указанным расширением
    List<String> getAllFilesNames(String folderPath, String extension);
}
