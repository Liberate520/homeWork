package DZ5_7.MVP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import DZ5_7.Models.Human;
import DZ5_7.Models.TypeGender;
import DZ5_7.Structure.FamilyTree;

public class Model<T> {
    private String path = "homeWork\\src\\DZ5_7\\familyTreePetrov.db";
    public FamilyTree<T> familyTree;

    public Model() {
        this.familyTree = new FamilyTree<T>();
    }

    public FamilyTree<T> familyTree() {
        return familyTree;
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(familyTree.getList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            familyTree.setList(((ArrayList<T>) ois.readObject()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
