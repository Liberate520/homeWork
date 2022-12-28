package gb.task_4;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human extends LiveBeing {

    public Human(String name, int date, String sex) {
        super(name, date, sex);
    }

    public Human(String name) {
        super(name);
    }

    @Override
    public List getChildren() {
        return super.getChildren();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setFather(Human father) {
        super.setFather(father);
    }

    @Override
    public void setMother(Human mother) {
        super.setMother(mother);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getDate() {
        return super.getDate();
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }

    @Override
    public int compareTo(LiveBeing o) {
        return super.compareTo(o);
    }
}
