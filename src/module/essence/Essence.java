package module.essence;

import java.io.Serializable;
import java.util.*;

public interface Essence<T> extends Serializable {
    public String getName();

    void setName(String name);

    public Date getDate_of_birth();

    public void setDate_of_birth(Calendar date_of_birth);

    public Integer getDay();

    public void setDay(Integer day);

    public Integer getMonth();

    public void setMonth(Integer month);

    public Integer getYear();

    public void setYear(Integer year);

    public Gender getGender();

    public void setGender(Gender gender);
    public List<T> getChildren();

    public void setChildren(T children);

    public List<T> getParents();

    public void setParents(T parent);

    public void setParents(T parent1, T parent2);

    public T getIn_marriage_with();
}
