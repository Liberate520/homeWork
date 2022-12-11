package service.dataBase;

import service.classes.Gender;
import service.classes.Marrige;
import service.classes.Person;

import java.util.ArrayList;
import java.util.Date;

/*
Интерфейс для работы с базой
 */
public interface DBHandler extends Iterable<Person> {
    void fill(int quantity);

    void setCreationDate(Date creationDate);

    Date getCreationDate();

    void setMainDB(ArrayList<Person> mainDB);

    void cloneDB(DBHandler db);

    int getSize();

    int getChildrenSize(int number);

    ArrayList<Person> getGeneration(int number);

    Person[] getFamily(int index);

    Person getPerson(int index);

    void addPerson(Person person);

    ArrayList<Person> getPersons(ArrayList<Integer> indexes);

    ArrayList<Person[]> getFullFamilies();

    ArrayList<Person[]> getFamilies();

    int getFamiliesNumber();

    void addFamily(Person[] family);

    void addFamilyToCache(Person[] family);

    ArrayList<Person[]> getCachedFamilies();

    void familiesCacheFlush();

    void includeDB(DBHandler otherDB);

    void includeFamilies(DBHandler otherDB);

    ArrayList<Person> getListOf(Gender state, int generation);

    ArrayList<Person> getListOf(Marrige state);

    ArrayList<Person> getMainDB();
}
