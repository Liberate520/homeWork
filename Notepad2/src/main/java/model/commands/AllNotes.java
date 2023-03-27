package model.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllNotes implements CommandsInterface{
    private final String NAME = "Просмотреть все записи.";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String result() {
        String res = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Notes.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
//                return "==" + str + "==\n";
                res += str + "\n";
            }
            br.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
