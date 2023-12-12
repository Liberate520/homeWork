package homeWork.src.model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<I> extends Serializable, Comparable<I> {
    int getAge();
    LocalDate getBirthDate();

    long getId();

    String getName();

    I getSpouse();

//    void setSpouse(FamilyMember<M> member);

    List<I> getParents();

    List<I> getChildren();

    boolean addChild(I child);

    Gender getGender();

    boolean addParent(I parent);

    void setSpouse(I member2);
}
