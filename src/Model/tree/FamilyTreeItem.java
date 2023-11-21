package Model.tree;

import Model.human.Gender;
import Model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Serializable {
    public void setSpouse(T spouse);
    public void setId(int id);
    public void setDayOfBirth(LocalDate dayOfBirth);
    public void setDayOfDeath(LocalDate dayOfDeath);
    public  void setChild(T human);
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
