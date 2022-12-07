package service.dataBase;

import service.classes.Gender;
import service.classes.Marrige;
import service.classes.Person;
import service.generator.PersonGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import static service.tree.RelationType.DAUGHTER;
import static service.tree.RelationType.SON;

/*
Класс - база для хранения объектов Person и семейных пар
 */
public class DataBase implements Serializable, Iterable<Person>, DBHandler {
    private final ArrayList<Person> db;
    private final ArrayList<Person[]> familiesList;
    private Date creationDate;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public int getSize() {
        return db.size();
    }

    public Person get(int index) {
        return db.get(index);
    }

    public Person[] getFamily(int index) {
        return familiesList.get(index);
    }

    /*
    возвращает список записей имеющих определённый статус гендера
     */
    public ArrayList<Person> getListOf(Gender state) {
        ArrayList<Person> results = new ArrayList<>();
        for (Person person : db) {
            if (person.getGender() == state) {
                results.add(person);
            }
        }
        return results;
    }

    public ArrayList<Person> getListOf(Marrige state) {
        ArrayList<Person> results = new ArrayList<>();
        for (Person person : db) {
            if (person.getMarigeStatus() == state) {
                results.add(person);
            }
        }
        return results;
    }

    public ArrayList<Person> getDb() {
        return this.db;
    }

    /*
     * заполнить базу
     */
    public void fill(int quantity) {
        for (int i = 0; i < quantity; i++) {
            db.add(PersonGenerator.create());
        }
    }

    /*
    добавляет другую db
     */
    @Override
    public void includeDB(DBHandler nextGeneration) {
        this.db.addAll(nextGeneration.getDb());
        this.familiesList.addAll(nextGeneration.getFullFamilies());
    }

    /*
    добавляет семьи из другой базы
     */
    public void includeFamilies(DBHandler nextGeneration) {
        this.familiesList.addAll(nextGeneration.getFullFamilies());
    }

    public void add(Person person) {
        db.add(person);
    }

    public ArrayList<Person[]> getFamilies() {
        return familiesList;
    }

    /* количество семей в базе */
    public int getFamiliesNumber() {
        return familiesList.size();
    }

    public ArrayList<Person[]> getFullFamilies() {
        ArrayList<Person[]> fullFamiliesList = new ArrayList<>();
        for (Person[] family : familiesList) {
            if (family[0].checkMember(SON) || family[0].checkMember(DAUGHTER)) {
                fullFamiliesList.add(family);
            }
        }
        return fullFamiliesList;
    }

    @Override
    public void addFamily(Person[] family) {
        familiesList.add(family);
    }

    public DataBase(ArrayList<Person> db) {
        this.db = db;
        this.familiesList = new ArrayList<>(2);
    }

    public DataBase() {
        this(new ArrayList<>());
    }

    @Override
    public Iterator<Person> iterator() {
        return new DataBaseIterator(this.db);
    }
}
