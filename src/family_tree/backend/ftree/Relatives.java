package family_tree.backend.ftree;

import family_tree.backend.person.Gender;

import java.time.LocalDate;

public interface Relatives<T>{

    String getName();
    String getLFName();
    String getBirthData();

    long getID();
    Gender getGender();
    String getPerson();
    T getFather();
    T getMother();

    void setFather(T father);

    void setMother(T mother);

//    void setMarriage(T spouse, String name, LocalDate date);

    //    T addPerson();
//    T getPersonObj();
//    String getPersonSiblings();
//    String getPersonChildrens();

}
