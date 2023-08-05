package family_tree.backend.ftree;

import family_tree.backend.person.Gender;

public interface Relatives<T>{

    String getName();
    String getLFName();
    String getBirthData();

    long getID();
    Gender getGender();
    String getPerson();
    T getFather();
    T getMother();

    //    T addPerson();
//    T getPersonObj();
    String getPersonSiblings();
    String getPersonChildrens();

}
