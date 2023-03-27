package model;

import java.util.ArrayList;
import java.util.List;

public class PlanManager {
    // ПОЛЯ КЛАССА
    private final List<Plan> list;

    // КОНСТРУКТОР

    public PlanManager() {
        this.list = new ArrayList<>();
    }

    // МЕТОДЫ КЛАССА

    public List<Plan> getAll() {
        return this.list;
    }

    public int getSize() {
        return this.list.size();
    }

    public void clear() {
        this.list.clear();
    }

    public void addRec(String task, String deadline, String notes) {
        this.list.add(new Task(task, deadline, notes));
    }

    public void addClass(Plan rec) {
        this.list.add(rec);
    }

    public void delRec(Integer index) {
        try {
            if (index > 0 && index <= this.list.size())
                this.list.remove(index-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeRec(Integer index, String task, String deadline, String notes){
        try {
            if (index > 0 && index <= this.list.size())
                this.list.remove(index-1);
            this.list.add(new Task(task, deadline, notes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.list.size() == 0)
            return sb.append("НЕТ ЗАПИСЕЙ").toString();
        sb.append("ПЛАН МЕРОПРИЯТИЙ:\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("Запись № %d\n ", i+1));
            sb.append(list.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}