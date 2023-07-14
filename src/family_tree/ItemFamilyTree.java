package family_tree;

import family_tree.group.GroupItemAgedNamed;

import java.time.LocalDate;

public interface ItemFamilyTree<T> extends GroupItemAgedNamed {
    public int getId();
    public boolean addChild(T t);
    public Gender getGender();
    public LocalDate getDateBirth();
    public T getSpouse();
    public void setSpouse(T t);
}
