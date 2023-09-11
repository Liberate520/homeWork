package model.Human;

import java.time.LocalDate;
import java.util.List;

public interface GroupItem<P> {

    boolean addChild(P child);

    boolean addParent(P parent);
    void setSpouse(P spouse);

    P getFather();
    P getMother();

    int getAge();

    int getPeriod(LocalDate birth, LocalDate death);

    P getSpouse();

    String getName();

    long getId();

    void setId(long id);

    void setBirth(LocalDate birth);

    LocalDate getBirth();

    void setDeath(LocalDate death);

    LocalDate getDeath();

    List<P> getParents();

    List<P> getChildren();

    String getInfo();

    String getSpouseInfo();

    String getMotherInfo();

    String getFatherInfo();

    String getChildrenInfo();



}