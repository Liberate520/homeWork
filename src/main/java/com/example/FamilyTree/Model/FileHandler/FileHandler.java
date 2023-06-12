package com.example.FamilyTree.Model.FileHandler;

import com.example.FamilyTree.DataForTree.FamilyTree;

import java.io.*;

public class FileHandler implements FileProcessing {

    @Override
    public void save(String path, Serializable object) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(object);
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public FamilyTree read(String path) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            FamilyTree ft = (FamilyTree) in.readObject();
            in.close();
            return ft;
        } catch (Exception e) {
            System.err.println(e);
            return new FamilyTree();
        }
    }
}
