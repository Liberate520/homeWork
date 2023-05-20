package model.Elements;

import java.io.Serializable;
import java.util.Objects;

public abstract class TreeElement implements Serializable, Comparable<TreeElement> {
     String name;

     int birthday;
     int deathDay;

    public  TreeElement(String name, int birthday, int deathDay) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeElement that = (TreeElement) o;
        return birthday == that.birthday && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}
