import java.util.*;
import java.text.*;

public class Human {
    private String dob; // дата рождения
    private String name;
    private Sex sex;

    public Human(String name, Sex sex, String dob) {
            this.name = name;
            this.sex = sex;
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date date = format.parse(dob);
                this.dob = String.valueOf(dob);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public String getDob() {
        return dob;
    }
    public String getName() {
        return name;
    }
    public Sex getSex() {
        return sex;
    }
}
