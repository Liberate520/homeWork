package model.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllNotes implements CommandsInterface{
    private final String NAME = "Просмотреть все записи. (комманда all)";
    private final String KEY = "all";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String result(String text) {

        String res = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Notes.txt"))) {
            String str;
            int i = 1;
            while ((str = br.readLine()) != null) {
                res += i + ". " + str + "\n";
                i++;
            }
            res += "\n Выход в главное меню \n";
            br.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
