package tree;

import human.Gender;
import human.Human;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public interface FamilyTreeItem<T> extends Comparable<T> {
    public void setSpouse(T spouse);
    public void setId(int id);
    public void setDayOfBirth(LocalDate dayOfBirth);
    public void setDayOfDeath(LocalDate dayOfDeath);
    public void setChild(T human);
    public void setParent(T human);

    public String getSpouse();
    public String getChildren();
    public String getParents();
    public Gender getGender();
    public int getAge();
    public String getId();
    public String getName();
    public String getLastname();
    public String getFullName();
    public LocalDate getDayOfBirth();
    public LocalDate getDayOfDeath();
//    public String toString();

}
