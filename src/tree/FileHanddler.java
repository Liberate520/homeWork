package tree;

import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHanddler implements Writeble {


private File file = new File("homeWork\\src\\file.txt");

@Override
public void save(List<Human> familyTree) throws IOException {
    FileWriter writer = new FileWriter(file, true);    
        for (Human human : familyTree) {
            if (human.getFather() == null || human.getMother() == null) {
                writer.write(human.getname() + " имеет детей: " + human.getChildren() + "\n");
            } else if (human.getChildren().size() == 0) {
                writer.write(human.getname() + " " + human.getLastname() + " имеет родителей " + human.getParents() + "\n");
            } else
                writer.write(human.getname() + " " + human.getLastname() + " имеет родителей " + human.getParents() + "\n"
                        + " и детей " + human.getChildren() + "\n");
        }
    
    writer.close();
}

@Override
public void load() {
    try {
        this.file.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public void read() {
    try {
        FileReader reader = new FileReader(this.file);
        char[] x = new char[(int) this.file.length()];
        reader.read(x);
        System.out.println(x);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
}
