package service.analizator;

import java.io.Serializable;
import java.util.ArrayList;

/*
Класс предоставляет StringBuilder и возвращает строку.
 */
public class StatWorker implements Serializable {
    private ArrayList<String> stats;
    private final StringBuilder line = new StringBuilder();


    public StatWorker() {
        this(new ArrayList<>());
    }


    public StatWorker(ArrayList<String> stats) {
        this.stats = stats;
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
        }
        return line.toString();
    }
}
