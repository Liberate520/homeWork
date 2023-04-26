package src.main.java;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class FileGenealogyTreeWriter implements GenealogyTreeWriter {
    @Override
    public void save(GenealogyTree tree, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        Person root = tree.getRoot();
        writePerson(root, writer, 0);
        writer.close();
    }

    private void writePerson(Person person, BufferedWriter writer, int level) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(person.getFullName());
        sb.append(" (").append(person.getGender()).append(", ").append(person.getBirthYear()).append(")");
        writer.write(sb.toString());
        writer.newLine();
        List<Person> children = person.getChildren();
        for (Person child : children) {
            writePerson(child, writer, level + 1);
        }
    }
}
