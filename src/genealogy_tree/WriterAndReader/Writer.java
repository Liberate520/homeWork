package genealogy_tree.WriterAndReader;

import genealogy_tree.Human.Human1;
import genealogy_tree.Human.Human2;
import genealogy_tree.Human.Human3;
import genealogy_tree.Tree.VeneologiTree;

import java.io.*;

public class Writer   {

    public Writer() {
        VeneologiTree geneologiTree = new VeneologiTree();
        Human1 human1 = new Human1();
        Human2 human2 = new Human2();
        Human3 human3 = new Human3();
        geneologiTree.addHuman(human1);
        geneologiTree.addHuman(human3);
        geneologiTree.addHuman(human2);

        String geneologiTree2 = geneologiTree.getHumanInfo();


        try (FileWriter writer = new FileWriter("genealogy_tree", false)) {
            writer.write(String.valueOf(geneologiTree2));
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }



    }
