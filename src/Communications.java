import java.util.ArrayList;
import java.util.List;

public class Communications {
    private List<Person> family;

    public Communications() {
        this(new ArrayList<>());
    }

    public Communications(List<Person> family) {
        this.family = family;
    }

    public List<Person> getFamily() {
        return family;
    }

    public void setFamily(List<Person> family) {
        this.family = family;
    }

    public void addInFamily(Person s) {
        getFamily().add(s);
    }

    @Override
    public String toString() {
        String result = new String();
        for (Person elem : family) {
            result += elem +"\n";
        }
        return result;
    }


}
