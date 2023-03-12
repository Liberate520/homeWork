package Interface;

import java.io.Serializable;

public interface Service {

    void save();
    void load();
    String showAllPerson();
    void sortByName();
    void sortByDateOfBirth();
    String showPerson(Integer cur);
    String сhildrentoSring (Integer cur);
    abstract void addFater(Integer cur, Integer fat);
    abstract void addMother(Integer cur, Integer mot);
    abstract void addChild(Integer cur, Integer chil);
    
}
