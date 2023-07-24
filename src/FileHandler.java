import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FileHandler implements Writable {
    private List <Object> list ;
    public FileHandler(){
        this.list=new ArrayList<>();
    }
    public void save(Object object) throws FileNotFoundException, IOException{
        this.list.add(object);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Externals.out"));
        out.writeObject(list);
        //out.writeObject(renat);
        out.close();


        
    }
     public Object load() throws FileNotFoundException, IOException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Externals.out"));
        
        StringBuilder stringBuilder = new StringBuilder();
        
        try {
            
            for (Object object :(List<Object>) in.readObject()){
                stringBuilder.append(object);
                stringBuilder.append("\n");

            }
            in.close();
            return stringBuilder.toString();
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
           return null;
        }
        
    }
    
}
