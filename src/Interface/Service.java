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
    // void addFater(Integer cur, Integer fat);
    // void addMother(Integer cur, Integer mot);
    void addChild(Integer cur, Integer chil, Integer delChil);
    
}
