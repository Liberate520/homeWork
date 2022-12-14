package Model;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Loader<T> {

    public ArrayList<T> load_tree (String path){

        ArrayList<T> base = new ArrayList<>();
        File file = new File(path);           
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (true) {
                    base.add((T) new Human(line));
                    }
                //     if (false) {             заглушка на будущий класс
                //         base.add((T) new Pet(line));
                //         }
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        return base;
    }
}




