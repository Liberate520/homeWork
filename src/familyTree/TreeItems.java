package familyTree;

import familyTree.person.Person;

public interface TreeItems {

    String getName();
    int getAge();
    String getInfo();
    int getGender();


    Person getMother();
    Person getFather();
    boolean addChild (Person child);



}
