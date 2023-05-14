package Elements;

import java.io.Serializable;

public abstract class TreeElement implements Serializable, Comparable<TreeElement> {
     String name;

     int birthday;
     int deathDay;

    public TreeElement(String name, int birthday, int deathDay) {
        this.name = name;
        this.birthday = birthday;
        this.deathDay = deathDay;
    }

    public String getName() {
        return name;
    }

    public int getBirthday() {
        return birthday;
    }

    public int getDeathDay() {
        return deathDay;
    }

}
