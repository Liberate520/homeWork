package model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Record> list;

    public Notebook() {
        this.list = new ArrayList<>();
    }

    public List<Record> getAll() {
        return this.list;
    }

    public int getSize() {
        return this.list.size();
    }

    public void clear() {
        this.list.clear();
    }

    public void addRec(String text, String deadline) {
        this.list.add(new Task(text, deadline));
    }

    public void addClass(Record rec) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.list.size() == 0)
            return sb.append("список пуст").toString();
        sb.append("---- список записей ----\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("> %d ", i+1));
            sb.append(list.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
