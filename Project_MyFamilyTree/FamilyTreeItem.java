package Project_MyFamilyTree;

import java.time.LocalDate;

public interface FamilyTreeItem<T> {
    public void FamilyTree ();
    public void addHuman ();
    public T findHuman();
    public String getHuman();
    public void sortByName();
    public void sortByAge();
    public String getName ();
    public LocalDate getBirthday ();
}