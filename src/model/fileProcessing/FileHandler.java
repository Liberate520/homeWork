package model.fileProcessing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import model.project.FamilyTree;
import model.project.User;
 
public class FileHandler<T extends User> implements Serializable{
    private Writeable format_write;

    public void saveTree(FamilyTree<T> familyTree) {
        try (FileOutputStream fileOut = new FileOutputStream("src/model/fileProcessing/FamilyTree.ser")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree<T> loadTree() {
        FamilyTree<T> familytree = new FamilyTree<>();
        try (FileInputStream fileIn = new FileInputStream("src/model/fileProcessing/FamilyTree.ser")) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            familytree = (FamilyTree<T>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return familytree;
    }

    public void write(FamilyTree<T> familyTree, String fileName) {
        formatWrite(fileName);
        HashMap<Integer, String> index_by_gen = familyTree.getHumansIndexByGeneration();
        ArrayList<T> hum_list = familyTree.getHumansList();
        String [] file = new String [hum_list.size()];
        String separator = "FileHandler";
        for (int i = 0; i < hum_list.size(); i++) {
            T human = hum_list.get(i);
            Integer gen = -1;
            for (int j = 1; j <= index_by_gen.size(); j++) {
                if (index_by_gen.get(j).contains(Integer.toString(i))) {
                    gen = j;
                    break;
                }
            }
            file[i] = Integer.toString(gen) + separator + human.getName() + separator + human.getSex() + separator 
                    + Integer.toString(human.getYearOfBirth()) + separator + human.getFatherName(human.getFather()) + separator 
                    + human.getMotherName(human.getMother()) + separator + human.getChildrenName(human.getChildren());
        }
        try {
            format_write.write(fileName, file, separator);
        } catch (Exception e) { System.out.println("Ошибка записи"); }
    }

    public void formatWrite(String fileName) {
        if (fileName.indexOf(".txt") != -1) format_write = new FileFormatTxt();
    }
}
