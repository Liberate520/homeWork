package service.dataBase;

import service.classes.Gender;
import service.classes.Marrige;
import service.classes.Person;

import java.util.ArrayList;
import java.util.Date;

public interface DBHandler extends Iterable<Person> {
    void fill(int quantity);

    void setCreationDate(Date creationDate);

    Date getCreationDate();


    int getSize();

    Person[] getFamily(int index);

    Person get(int index);

    ArrayList<Person[]> getFullFamilies();

    ArrayList<Person[]> getFamilies();

    int getFamiliesNumber();

    void addFamily(Person[] family);

    void includeDB(DBHandler otherDB);

    ArrayList<Person> getListOf(Gender state);

    ArrayList<Person> getListOf(Marrige state);

    ArrayList<Person> getDb();

}
