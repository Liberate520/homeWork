package gb.task_4;

import java.util.List;

public class Human extends LiveBeing {

    public Human(String name, int date, String sex) {
        super(name, date, sex);
    }

    public Human(String name) {
        super(name);
    }

    @Override
    public List<Human> getChildren() {
        return super.getChildren();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setFather(LiveBeing father) {
        super.setFather((Human) father);
    }

    @Override
    public void setMother(LiveBeing mother) {
        super.setMother((Human) mother);
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
        return String.format("Вид: Человек разымный\n%s", super.toString());
    }

    @Override
    public int compareTo(LiveBeing o) {
        return super.compareTo((Human) o);
    }
}
