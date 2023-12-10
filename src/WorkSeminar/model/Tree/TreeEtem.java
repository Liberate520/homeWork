package WorkSeminar.model.Tree;

import WorkSeminar.model.Persona.Gender;

import java.time.LocalDate;
import java.util.List;

public interface TreeEtem <T> {
    String getName();
    int addAge();
    Gender getGender();
    List<T>getKids();
    void setDathday(LocalDate dathday);
    void setId(long l);
    long getId();
    void addKid(T person);
    List<T> addParents();
    boolean addParent(T parent);
    T getPartner();
    void setPartner(T partner);
    String addAlive();


}
