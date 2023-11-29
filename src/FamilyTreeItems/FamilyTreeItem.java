package FamilyTreeItems;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem {
    public long getId();
    public String getFirstName();
    public String getLastName();
    public LocalDate getBirthDate();
    public LocalDate getDeathDate();
    public int getAge();
    public Sex getSex();
    public FamilyTreeItem getFather();
    public FamilyTreeItem getMother();
    public boolean setId(long id);
    public void setFirstName(String name);
    public void setLastName(String name);
    public boolean setMother(FamilyTreeItem mother);
    public boolean setFather(FamilyTreeItem father);
    public boolean addChild(FamilyTreeItem child);
    public List<FamilyTreeItem> getChildren();
    public int getChildrenAmount();
    public String getFullName();
} 