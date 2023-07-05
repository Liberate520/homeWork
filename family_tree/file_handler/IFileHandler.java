package family_tree.file_handler;

import java.util.List;

import family_tree.humans.Human;

public interface IFileHandler {
    void writeToFile(List<Human> allHumans, String fileName);

    List<Human> readFromFile(String fileName);
}
