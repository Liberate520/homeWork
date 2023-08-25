package com.javacourse.Family_tree;
import java.io.*;
import java.util.*;

public class myFile implements my_File{
    private File file;
    private Scanner scanner;
    private String[] str, params;
    public myFile(){
        this.file = new File("FamilyList.txt");
    }

    public Scanner file() throws IOException{
        scanner = new Scanner(file);
        if (scanner.hasNextLine()){
            return scanner;
        }
        scanner.close();
        return null;
    }

    public String[] read(){
        if (scanner.hasNextLine()){
            str = scanner.nextLine().split(", ");
            params = Arrays.copyOf(str, 4);
            return params;
        }
        scanner.close();
        return null;
    }
    
    public void write(Person human) throws IOException{
        FileWriter writer = new FileWriter("FamilyList.txt", true);
        String str = human.getName() + ", " + human.getAge() + ", " + human.getMom().getName() + ", " + human.getDad().getName() + "\n";
        writer.append(str);
        writer.close();
    }
    
    
}

