package Project_MyFamilyTree_MVP;

import java.time.LocalDate;

public interface FamilyTreeItem<T extends FamilyTreeItem> {
    public void FamilyTree();
    public void addHuman();
    public T findHuman();
    public String getHuman();
    public void sortByName();
    public void sortByAge();
    public String getName ();
    public LocalDate getBirthday();
}