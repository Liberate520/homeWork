package familyApi;

import java.io.IOException;

public interface Writable<T extends User> {
    void save(FamilyTree<T> family)  throws IOException, ClassNotFoundException;
    void load(FamilyTree<T> family)  throws IOException, ClassNotFoundException;
}
