package family_tree.model.tree;

public interface SentientEntity<E> extends Entity<E>{
    E getSpouse();
    boolean isMarried();
    void setSpouse(E spouse);

    void removeSpouse();
    boolean isHasBioFather();

    boolean isHasBioMother();

    void setHasBioFather();

    void setHasBioMother();
}
