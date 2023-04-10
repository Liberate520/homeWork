package SaveAndLoad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Person.*;
import Tree.*;

public class SaveTreeInTXT<E>{
    
    /**
     * @param familytree Список семейного древа
     * @param fileName Имя файла
     *  Сохранение семейного древа в файл
     */
    public void save(Tree<E> familytree, String fileName) {
        StringBuilder sb = new StringBuilder();
        for (E person: familytree){
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
