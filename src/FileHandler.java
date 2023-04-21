package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class FileHandler implements Serializable {
    private File file = new File("file.txt");
    
    public void outPut(FamilyTree familyTree) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream("file.txt"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree inPut() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("file.txt"));
        FamilyTree familyRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyRestored;
    }

    // @Override
    // public void save(HashSet<Human> familyTree) throws IOException {
    // FileWriter writer = new FileWriter(this.file, true);
    // try {
    // for (Human human : familyTree) {
    // if (human.getFather() == null || human.getMother() == null) {
    // writer.write(human.getName() + " имеет детей: " + human.getChildren() +
    // "\n");
    // } else if (human.getChildren().size() == 0) {
    // writer.write(human.getName() + " имеет отца " + human.getFather().getName() +
    // " и мать " + human.getMother().getName() + "\n");
    // } else
    // writer.write(human.getName() + " имеет отца " + human.getFather().getName() +
    // ", мать " + human.getMother().getName()
    // + " и детей " + human.getChildren() + "\n");
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // writer.close();
    // }

    // private void creatFile() {
    // try {
    // this.file.createNewFile();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // @Override
    // public void read() {
    // try {
    // FileReader reader = new FileReader(this.file);
    // char[] a = new char[(int) this.file.length()];
    // reader.read(a);
    // System.out.println(a);
    // // for (char c : a) {
    // // System.out.println(c);
    // // }
    // reader.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
}
