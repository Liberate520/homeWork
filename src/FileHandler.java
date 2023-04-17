package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class FileHandler implements Writable {
    private File file = new File("file.txt");

    @Override
    public void save(HashSet<Human> familyTree) throws IOException {
        FileWriter writer = new FileWriter(this.file, true);
        try {
            for (Human human : familyTree) {
                if (human.getFather() == null || human.getMother() == null) {
                    writer.write(human.getName() + " имеет детей: " + human.getChildren() + "\n");
                } else if (human.getChildren().size() == 0) {
                    writer.write(human.getName() + " имеет отца " + human.getFather().getName() + " и мать " + human.getMother().getName() + "\n");
                } else
                    writer.write(human.getName() + " имеет отца " + human.getFather().getName() + ", мать " + human.getMother().getName()
                            + " и детей " + human.getChildren() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
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
            char[] a = new char[(int) this.file.length()];
            reader.read(a);
            System.out.println(a);
            // for (char c : a) {
            //     System.out.println(c);
            // }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
