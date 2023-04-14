package SaveAndLoad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Tree.Person;
import Tree.Tree;

public class SaveInTxt {
        /**
     * @param familytree Список семейного древа
     * @param fileName Имя файла
     *  Сохранение семейного древа в файл
     */
    public static void save(Tree<Person> familytree, String fileName) {
        StringBuilder sb = new StringBuilder();
        for (Person person: familytree){
            sb.append(person);
            sb.append("\n"); 
        }

        File file = new File(fileName);
        try{
            FileWriter fr = new FileWriter(file,false);
            fr.write(sb.toString());    
            fr.close();
        }
        catch(IOException e) {
            System.out.println("ERROR");
        }
    }
    
}
