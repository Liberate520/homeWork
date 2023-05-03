package Package;

import Package.Model.WorkWithFiles.Files;

import java.io.*;

public class Test implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Files familyRestored = new Files("familyTree");
        familyRestored.readObj();
        System.out.println(familyRestored);
    }
}
