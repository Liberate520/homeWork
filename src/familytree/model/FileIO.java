package familytree.model;

import familytree.entities.Person;

import java.io.IOException;
import java.util.List;

public interface FileIO {
    void writeToFile(List<TreeEntity> people, String filename) throws IOException;

    List<Person> readFromFile(String filename) throws IOException;

}
