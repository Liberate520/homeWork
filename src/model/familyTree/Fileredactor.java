package model.familyTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import model.human.Human;
import presenter.Presenter;


public abstract class Fileredactor implements Saveandreadable {

    private String filename;
    private String relative;

    public Fileredactor (String filename) {
        this.filename = filename;
    }

    public Fileredactor () {
        this(null);
    }

    public void read_info (Tree family) throws IOException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line = bufferedReader.readLine();
        List<String> data = new ArrayList<>();
        while(line != null){
            Human newPerson = parsePerson(bufferedReader);
            family.addHuman(newPerson);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }


    private Human parsePerson (BufferedReader bufferedReader) throws IOException {
        Human newPerson  = new Human();
        String line = bufferedReader.readLine();
        while (line != null && !line.equals("Следующий человек")){
            String[] parsedLine = line.split(": ");
            if (parsedLine.length == 1){
                newPerson.setField("-", parsedLine[0]);
            }else{
                newPerson.setField(parsedLine[1], parsedLine[0]);
            }
            line = bufferedReader.readLine();
        }
        return newPerson;
    }

    public void printInfo(Tree<Human> o) throws IOException {
        FileWriter fileWriter = new FileWriter("family.txt", true);
        fileWriter.write("\n" + relative);
        fileWriter.close();
    }
}
 

