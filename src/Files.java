import java.util.Map;

public interface Files {
    Map<Integer, Person> readFile();

    Boolean saveFile(String f, Tree p);
}
