import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String years_of_life;
    private String years_of_reign;
    private Human father;
    private Human mather;
    public String[] child;

    public Human(String name, String years_of_life, String years_of_reign, Human father, Human mather, String[] child) {
        this.name = name;
        this.years_of_life = years_of_life;
        this.years_of_reign = years_of_reign;
        this.father = father;
        this.mather = mather;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public List<String> getComunity() { // Братья и сестры
        List<String> res = new ArrayList<>();
        for (int i = 0; i < father.getChild().length; i++) {
            if (father.getChild()[i].equals(name)) {
                continue;
            } else
                res.add(father.getChild()[i]);
        }
        return res;
    }

    public String[] getChild() {
        return child;
    }

    public String getYears_of_reign() {
        return years_of_reign;
    }

    public Human father() {
        return father;
    }

    public Human mather() {
        return mather;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Name: '" + name + '\'' +
                ", годы жизни: " + years_of_life +
                '}';
    }
}
