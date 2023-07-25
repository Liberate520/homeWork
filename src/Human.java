import java.util.ArrayList;
import java.util.List;

public class Human {
    private String fullName;

    public Human(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}