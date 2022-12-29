import java.util.List;

public class Human extends LiveBeing<Human> {

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
        return String.format("Вид: Человек разымный\n%s", super.toString());
    }

    @Override
    public int compareTo(Human o) {
        return super.compareTo(o);
    }
}
