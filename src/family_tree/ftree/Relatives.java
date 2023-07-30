package family_tree.ftree;

import family_tree.person.Gender;
import family_tree.person.Person;

public interface Relatives {
    String getName();
    String getBirthData();
    long getID();
    String getPerson();
    Person getFather();
    Person getMother();
    Gender getGender();

}
