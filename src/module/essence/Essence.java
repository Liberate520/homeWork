package module.essence;

import java.io.Serializable;
import java.util.*;

public abstract class Essence<T> implements Serializable {
    public String name;
    private Calendar date_of_birth;
    private Integer day;
    private Integer month;
    private Integer year;
    private Gender gender;
    private  List<T> children;
    private  List<T> parents;
    private Human In_marriage_with;
    public String getName() {
        return name;
    }

    abstract void setName(String name);

    abstract public Date getDate_of_birth();

    abstract public void setDate_of_birth(Calendar date_of_birth);

    public Integer getDay() {
        return day;
    }

    public abstract void setDay(Integer day);

    public Integer getMonth() {
        return month;
    }

    public abstract void setMonth(Integer month);

    public Integer getYear() {
        return year;
    }

    public abstract void setYear(Integer year);

    public Gender getGender() {
        return gender;
    }

    public abstract void setGender(Gender gender);
    public abstract List<T> getChildren();

    public abstract void setChildren(T children);

    public abstract List<T> getParents();

    public abstract void setParents(T parent);

    public abstract void setParents(T parent1, T parent2);

    public abstract T getIn_marriage_with();
}
