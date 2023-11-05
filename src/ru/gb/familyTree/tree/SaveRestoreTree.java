package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;
import ru.gb.familyTree.person.PersonSaver;

import java.io.*;

public class SaveRestoreTree implements WritableToFile{
        public SaveRestoreTree(){
            super();
        }
        @Override
        public void writeObject(Object treeName, String filename) throws IOException {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(treeName);
            out.close();
        }
        @Override
        public Object restoreObject(String filename) throws IOException, ClassNotFoundException {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            return in.readObject();
        }
}
