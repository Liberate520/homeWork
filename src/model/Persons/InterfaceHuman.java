package model.Persons;

import java.time.LocalDate;
import java.util.ArrayList;

public interface InterfaceHuman extends InterfacePerson
{
    String getLastName();
   String getFirstName();
   Gender getGender();
   LocalDate getDataBirth();
   LocalDate getDataDeath();
   Person getFather();
   Person getMother();
   ArrayList<Person> getChildren();
}
