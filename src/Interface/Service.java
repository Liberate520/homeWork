package Interface;

public interface Service {

    void save();
    void load();
    String showAllPerson();
    void sortByName();
    void sortByDateOfBirth();
    String showPerson(Integer cur);
    String сhildrentoSring (Integer cur);
    void addChild(Integer cur, Integer chil, Integer delChil);
    
}
