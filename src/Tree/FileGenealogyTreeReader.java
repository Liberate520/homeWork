package Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileGenealogyTreeReader implements GenealogyTreeReader {
    @Override
    public GenealogyTree load(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Map<String, Person> persons = new HashMap<>();
        String line;
        GenealogyTree tree = null;
        while ((line = reader.readLine()) != null) {
            int level = getLevel(line);
            String[] parts = line.trim().split("\\(");
            String name = parts[0].trim();
            String[] details = parts[1].replace(")", "").split(", ");
            String gender = details[0];
            int birthYear = Integer.parseInt(details[1]);
            Person person = new Person(name, Gender.valueOf(gender), birthYear);
            persons.put(name, person);
            if (level == 0) {
                tree = new GenealogyTree(person);
                continue;
            }
            String parentName = getParentName(line);
            Person parent = persons.get(parentName);
            if (level == 1) {
                tree.addChild(parent, person);
            } else {
                String grandParentName = getParentName(getParentLine(reader));
                Person grandParent = persons.get(grandParentName);
                tree.addParent(parent, grandParent, person);
            }
        }
        reader.close();
        return tree;
    }
    private int getLevel(String line) {
        int level = 0;
        while (line.startsWith("\t")) {
            level++;
            line = line.substring(1);
        }
        return level;
    }
    private String getParentName(String line) {
        return line.substring(line.lastIndexOf("\t") + 1);
    }
    private String getParentLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        while (line != null && !line.startsWith("\t")) {
            line = reader.readLine();
        }
        return line;
    }
}