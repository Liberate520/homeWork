package service.analizator;

import service.classes.Person;
import service.dataBase.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

import static service.classes.Gender.*;
import static service.classes.Marrige.*;

public class StatWorker implements Serializable {
    private ArrayList<String> stats;

    private final StringBuilder line = new StringBuilder();
    private final DataBase db;

    public StatWorker() {
        this(new DataBase());
    }


    public StatWorker(DataBase db) {
        this.stats = new ArrayList<>();
        this.db = db;
    }

    public ArrayList<String> getStats() {
        return stats;
    }

    public StatWorker(ArrayList<String> stats, DataBase db) {
        this(db);
        this.stats = stats;
    }

    /*
    собирает общую статистику по базе
     */
    public void getDBStats() {
        int married = 0;
        int single = 0;
        int man = 0;
        int woman = 0;
        for (Person person : this.db) {
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
        line.append("Size of DB = ").append(this.db.getDb().size()).append("\n");
        addNclear(line);

        line.append("Number of families: ").append(this.db.getFullFamilies().size()).append("\n");
        addNclear(line);

        line.append("Number of married people: ").append(married).append("\n");
        addNclear(line);

        line.append("Number of single people: ").append(single).append("\n");
        addNclear(line);

        line.append("Number of man: ").append(man).append("\n");
        addNclear(line);

        line.append("Number of woman: ").append(woman).append("\n");
        addNclear(line);
    }

    /*
    добавить в лист и стереть line
     */
    private void addNclear(StringBuilder line) {
        this.stats.add(line.toString());
        line.delete(0, line.length());
    }

    public void addPosition(String str) {
        this.line.append(str);
        addNclear(line);
    }

    public void addPosition(int num) {
        this.line.append(num);
    }


    /*
    собираем строку для сохранения
     */
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (String string : stats) {
            line.append(string);
//            line.append("\n");
        }
        return line.toString();
    }
}
