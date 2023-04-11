package model.save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClassWriteRead<T, H> implements Writable {
    private String name;
    private String description;

   // ArrayList<T> newHuman = new ArrayList<>();



    public ClassWriteRead(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "FamilyTree = " + '{' + name + '\'' + ", description='" + description + '\'' + '}';
    }



   

    @Override
    public void save(Object obj, String fileName) throws IOException {
         
        

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(obj);
        out.close();
        
    }

    @Override
    public Object read(String fileName) throws IOException, ClassNotFoundException {
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

        return in.readObject();

    }




}