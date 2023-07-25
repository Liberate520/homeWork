package genealogy_tree;
import genealogy_tree.WriterAndReader.*;

import java.io.*;


import genealogy_tree.WriterAndReader.Reader;
import genealogy_tree.WriterAndReader.Writer;


public class Main {
    public static void main (String[] args) throws IOException, ClassNotFoundException {

        new Writer();
        new Reader();
        Sirealize sier = new Sirealize();
        sier.ObjectOutputStream();
        sier.ObjectInputStream();



    }

}
