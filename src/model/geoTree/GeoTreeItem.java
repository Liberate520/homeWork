package model.geoTree;

import java.time.LocalDate;
import java.util.List;

public interface GeoTreeItem<T> {
    String getName();
    String getSurname();
    String getPatronymic();
    LocalDate getDateOfBirth();

    T getFather();
    T getMother();
    String getInfo();
    String getMotherInfo();
    String getFatherInfo();
    String getChildrenInfo();
    
    List<T> getChildren();
    boolean addChild(T o);
}
