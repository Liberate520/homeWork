package mvp.model.geoTree;

import java.util.List;

public interface GeoTreeIterable<T> extends Iterable<T> {
    void addPerson(T person);

    List<T> getPersonList();

    void sortByName();

    void sortByDateOfBirth();
}
