package SaveAndLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Person.Person;
import Tree.FamilyTree;

public class SaveSerialization{


    // Нерабочие методы !!!
    
    // public static  void save(FamilyTree familytree, String fileName) throws IOException {
    //     ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
    //     objectOutputStream.writeObject(familytree);
    //     objectOutputStream.close();
    // }
    
    // public static FamilyTree load(String fileName) throws IOException, ClassNotFoundException {
    //     ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
    //     FamilyTree RestoredFamily = (FamilyTree) objectInputStream.readObject();
    //     objectInputStream.close();
    //     return RestoredFamily;
    // }
    
}