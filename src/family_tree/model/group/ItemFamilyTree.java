package family_tree.model.group;

import family_tree.model.Gender;

import java.time.LocalDate;

public interface ItemFamilyTree<T> {
    String getName();
    String getInfo();
    int getAge();
    public int getId();
    public boolean addChild(T t);
    public Gender getGender();
    public LocalDate getDateBirth();
    public T getSpouse();
    public void setSpouse(T t);
}
