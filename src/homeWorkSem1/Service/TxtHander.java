package homeWorkSem1.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;


import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;


public class TxtHander implements Writeble<FamilyTree<Human>> {

    @Override
    public void save(Serializable serializable) {
        try (FileWriter fw = new FileWriter("FamilyTree.txt", true)) { 
            fw.write(serializable.toString());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }    
    }

    /**метод read из файла с получением строки данных*/
    public String readGetString() throws IOException {
        String treeArray = "";
        BufferedReader reader = new BufferedReader(new FileReader("FamilyTree.txt"));
        String line = reader.readLine();
        while (line != null) {
            treeArray += line;
            line = reader.readLine();
        }
        reader.close();
        return treeArray;
    }

    /**метод read из файла с получением списка FamilyTree(human)*/
    public FamilyTree<Human> read() throws IOException {
        String treeArray = "";
        String [] result;
        BufferedReader reader = new BufferedReader(new FileReader("FamilyTree.txt"));
        String line = reader.readLine();
        while (line != null) {
            treeArray += line;
            line = reader.readLine();
        }
        reader.close();
        result = treeArray.replace(":", "").replace("[", "")
        .replace("]", "").replace(",", "").split(" ");

        FamilyTree<Human> tree = new FamilyTree<>();
        for (int index = 1; index < result.length-2;) {   
            Human human = new Human(result[index], Integer.parseInt(result[index+2]), Gender.valueOf(null, line), null, null, Integer.parseInt(result[index+5]));
            tree.add(human);
            index +=6;    
        }
        return tree;                
    } 
}
