import java.io.*;

public class MethodClass implements Serializable {
    private String string;
    private String description;

    public MethodClass(String string, String description) {
        this.string = string;
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

    //
    @Override
    public String toString() {
        return "FamilyTree = " +'{' + string + '\'' +  ", description='" + description + '\'' +'}';
    }

  
}