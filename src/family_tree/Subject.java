package family_tree;

public interface Subject<T> {
    String getName();
    int getAge();
    String getGender();
    T getMother();
    T getFather();
}