package model.fileProcessing;

import java.io.FileWriter;
import java.io.IOException;

public class FileFormatTxt implements Writeable {
    @Override
    public void write(String fileName, String [] file, String separator) {
        try {
            FileWriter writer = new FileWriter(fileName);
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
        } catch (IOException e) { System.out.println("Ошибка записи"); }
    }
}
