package family_tree.model;

public interface Subject<T> {
    int getID();

    String getName();

    int getAge();

    String getGender();

    T getMother();
    T getFather();

    void setMother(T human);

    void setFather(T human);
}

