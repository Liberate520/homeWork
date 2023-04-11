//package treePackage;
import java.io.*;

public class MethodClassSerializable implements Serializable {
    private String name;
    private String description;

    public MethodClassSerializable(String name, String description) {
        this.name = name;
        this.description = description;
    }


    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Our writeObject");
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        System.out.println("Our readObject");
    }

    @Override
    public String toString() {
        return "FamilyTree = " +'{' + name + '\'' +  ", description='" + description + '\'' +'}';
    }

  
}