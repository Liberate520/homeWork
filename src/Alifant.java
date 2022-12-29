import java.util.List;

public class Alifant extends LiveBeing<Alifant> {

    public Alifant(String name, int date, String sex) {
        super(name, date, sex);
    }

    public Alifant(String name) {
        super(name);
    }

    @Override
    public List<Alifant> getChildren() {
        return super.getChildren();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setFather(Alifant father) {
        super.setFather(father);
    }

    @Override
    public void setMother(Alifant mother) {
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
        return String.format("Вид: Слон белый\n%s", super.toString());
    }

    @Override
    public int compareTo(Alifant o) {
        return super.compareTo(o);
    }
}
