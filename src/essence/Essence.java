package essence;

import java.io.Serializable;
import java.util.*;

public abstract class Essence<T> implements Serializable {
    abstract public String getName();

    abstract void setName(String name);

    abstract public Date getDate_of_birth();

    abstract public void setDate_of_birth(Calendar date_of_birth);

    abstract public Integer getDay();

    abstract public void setDay(Integer day);

    abstract public Integer getMonth();

    abstract public void setMonth(Integer month);

    abstract public Integer getYear();

    abstract public void setYear(Integer year);

    abstract public Gender getGender();

    abstract public void setGender(Gender gender);
    abstract public List<T> getChildren();

    abstract public void setChildren(T children);

    abstract public List<T> getParents();

    abstract public void setParents(T parent);

    abstract public void setParents(T parent1, T parent2);

    abstract public T getIn_marriage_with();
}
