package fileProcessing;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileFormatTxt implements Writeable, Readable {
    @Override
    public ArrayList<String[]> read(String file_name) throws IOException {
        file_name = "src/" + file_name + ".txt";
        FileReader reader = new FileReader(file_name);
        String readfile = "";
        int symbol;
        while((symbol = reader.read()) != -1){
            readfile += (char)symbol;
        }
        reader.close();
        String separator = "separatorfortxt";
        readfile = readfile.replace("Поколение ", "");
        readfile = readfile.replace(": ", separator);
        readfile = readfile.replace(" (", separator);
        readfile = readfile.replace(") ", separator);
        readfile = readfile.replace(" года рождения", "");
        readfile = readfile.replace(", Отец - ", separator);
        readfile = readfile.replace(", Мать - ", separator);
        readfile = readfile.replace(", Дети - ", separator);
        String [] file = readfile.split("\n");
        ArrayList<String[]> result = new ArrayList<>();
        for (int i = 1; i < file.length; i++) {
            result.add(file[i].split(separator));
        }
        return result;
}

    @Override
    public void write(String file_name, String [] file, String separator) throws IOException {
        if (file_name == null) file_name = "src/FamilyTree.txt";
        else file_name = "src/" + file_name + ".txt";
        FileWriter writer = new FileWriter(file_name);
        writer.write("Генеалогическое древо.\n");
        for (int i = 0; i < file.length; i++) {
            String [] line = file[i].split(separator);
            writer.write("Поколение " + line[0] + 
                        ": " + line[1] + 
                        " (" + line[2] + 
                        ") " + line[3] + " года рождения" +
                        ", Отец - " + line[4] + 
                        ", Мать - " + line[5] + 
                        ", Дети - " + line[6] + 
                        "\n");
        }
        writer.close();
    }
}
