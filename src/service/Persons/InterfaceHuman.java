package service.Persons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceHuman extends InterfacePerson {
    String getName();
    int getDate();
    Gender getGender();
    Person getFather();
    Person getMother();
    ArrayList<Person> getChildren() ;
}
