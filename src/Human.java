import java.util.ArrayList;
import java.util.List;

public class Human {
    private String fullName;
    private List<Human> family = new ArrayList<>();

    public List<Human> getFamily() {
        return family;
    }

    public Human(String fullName) {
        this.fullName = fullName;
    }

    public void appendToFamily(Human h) {
        family.add(h);
    }

    @Override
    public String toString() {
        return fullName;
    }
}
