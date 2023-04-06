package workingFile;

import human.Human;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MethodClass implements WritableInterf {
    private String string;
    private String description;

    public MethodClass(String string, String description) {
        this.string = string;
        this.description = description;
    }


    public void writeObj(Human human)  {
//        stream.defaultWriteObject();
//        System.out.println("Our writeObject");
    }

    public void readObj(Human human)  {
//        stream.defaultReadObject();
//        System.out.println("Our readObject");
    }

    //
    @Override
    public String toString() {
        return "FamilyTree = " +'{' + string + '\'' +  ", description='" + description + '\'' +'}';
    }

  
}