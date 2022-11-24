import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class load_data {
    
    public static ArrayList<Person> load_CVS(String path) {
        System.out.println("loading...");
        ArrayList<Person> base= new ArrayList<>();
        File file = new File(path);           
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String [] data = line.split(";");
                base.add(new Person(data));
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return base;
    }


}

