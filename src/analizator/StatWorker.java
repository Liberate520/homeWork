package analizator;

import classes.Person;
import dataBase.DataBase;
import IO.IO;

import java.io.Serializable;
import java.util.ArrayList;

import static classes.Gender.*;
import static classes.Marrige.*;

public class StatWorker implements Serializable {
    ArrayList<String> stats;

    public StatWorker() {
        this.stats = new ArrayList<>();
    }

    /*
    собирает общую статистику по базе
     */
    public void getStats(DataBase db) {
        StringBuilder line = new StringBuilder();
        int married = 0;
        int single = 0;
        int man = 0;
        int woman = 0;
        for (Person person : db) {
            if (person.getMarigeStatus() == YES) {
                married++;
            } else {
                single++;
            }
            if (person.getGender() == MALE) {
                man++;
            } else {
                woman++;
            }
        }
        line.append("Size of DB = ");
        line.append(db.getDb().size());
        addNclear(line);

        line.append("Number of families: ");
        line.append(db.getFullFamilies().size());
        addNclear(line);

        line.append("Number of married people: ");
        line.append(married);
        addNclear(line);

        line.append("Number of single people: ");
        line.append(single);
        addNclear(line);

        line.append("Number of man: ");
        line.append(man);
        addNclear(line);

        line.append("Number of woman: ");
        line.append(woman);
        addNclear(line);
    }

    /*
    добавить в лист и стереть line
     */
    private void addNclear(StringBuilder line) {
        this.stats.add(line.toString());
        line.delete(0, line.length());
    }

    /*
    собираем строку для сохранения
     */
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (String string : stats) {
            line.append(string);
            line.append("\n");
        }
        return line.toString();
    }

    public void save(String path) {
        IO saver = new IO();
        saver.toFile(this.stats, path);
    }

    public void load(String path) {
        IO loader = new IO();
        this.stats = (ArrayList<String>) loader.fromFile(path);
    }
}
