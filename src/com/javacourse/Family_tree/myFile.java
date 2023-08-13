package com.javacourse.Family_tree;
import java.io.*;
import java.util.*;

public class myFile implements my_File{
    private File file;
    public myFile(){
        this.file = new File("FamilyList.txt");
    }
    Scanner scanner;
    String[] str;
    String[] params;

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
    
    public void write(Person human){
        
    }
    
    
}

interface my_File {
    Scanner file() throws IOException;
    String[] read();
    void write(Person human);
}
