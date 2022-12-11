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
    private Date creationDate;
    private ArrayList<Person> mainDB;
    private ArrayList<Integer[]> familiesList;
    private ArrayList<Integer[]> cachedFamilies;

    public void setMainDB(ArrayList<Person> mainDB) {
        this.mainDB = mainDB;
    }

    @Override
    public void cloneDB(DBHandler otherDB) {
        this.mainDB =  otherDB.getMainDB();
        this.familiesList = otherDB.getFamilies();
    }

    public ArrayList<Integer[]> getCachedFamilies() {
        return cachedFamilies;
    }

    @Override
    public void familiesCacheFlush() {
//        this.familiesList.addAll(cachedFamilies);
        for (Integer[] cachedFamily : cachedFamilies) {
            System.out.println(getPerson(cachedFamily[0]).getGeneration() + " " + getPerson(cachedFamily[1]).getGeneration());
            this.familiesList.add(cachedFamily);
        }
        cachedFamilies.clear();
    }

    public void setCachedFamilies(ArrayList<Integer[]> cachedFamilies) {
        this.cachedFamilies = cachedFamilies;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public int getSize() {
        return mainDB.size();
    }


    @Override
    public int getChildrenSize(int number) {
        int count = 0;
        for (Person person : this.mainDB) {
            if (person.getGeneration() == number) {
            count++;
            }
        }
        return count;
    }

    @Override
    public ArrayList<Person> getGeneration(int number) {
        ArrayList<Person> generation = new ArrayList<>();
        for (Person person : mainDB) {
            if (person.getGeneration() == number) {
                generation.add(person);
            }
        }
        return generation;
    }

    public Person getPerson(int index) {
        return mainDB.get(index);
    }

    @Override
    public ArrayList<Person> getPersons(ArrayList<Integer> indexes) {
        ArrayList<Person> persons = new ArrayList<>();
        for (Integer index : indexes) {
            persons.add(getPerson(index));
        }
        return persons;
    }

    public int getPersonIndex(Person person) {
        return this.mainDB.indexOf(person);
    }

    public Integer[] getFamily(int index) {
        return familiesList.get(index);
    }

    /*
    возвращает список записей имеющих определённый статус гендера
     */
    public ArrayList<Person> getListOf(Gender state, int generation) {
        ArrayList<Person> results = new ArrayList<>();
        for (Person person : mainDB) {
            if (person.getGender() == state && person.getGeneration() == generation) {
                results.add(person);
            }
        }
        return results;
    }

    public ArrayList<Person> getListOf(Marrige state) {
        ArrayList<Person> results = new ArrayList<>();
        for (Person person : mainDB) {
            if (person.getMarigeStatus() == state) {
                results.add(person);
            }
        }
        return results;
    }

    public ArrayList<Person> getMainDB() {
        return this.mainDB;
    }

    /*
     * заполнить базу
     */
    public void fill(int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.addPerson(PersonGenerator.create());
        }
    }

    /*
    добавляет другую db
     */
    @Override
    public void includeDB(DBHandler nextGeneration) {
        for (Person person : nextGeneration) {
            this.addPerson(person);
        }
        includeFamilies(nextGeneration);
    }

    /*
    добавляет семьи из другой базы
     */
    public void includeFamilies(DBHandler nextGeneration) {
        this.familiesList.addAll(nextGeneration.getFullFamilies());
    }

    public void addPerson(Person person) {
        this.mainDB.add(person);
        person.setDbIndex(mainDB.indexOf(person));
    }

    public ArrayList<Integer[]> getFamilies() {
        return familiesList;
    }

    /* количество семей в базе */
    public int getFamiliesNumber() {
        return familiesList.size();
    }

    public ArrayList<Integer[]> getFullFamilies() {
        ArrayList<Integer[]> fullFamiliesList = new ArrayList<>();
        for (Integer[] family : familiesList) {
            if (mainDB.get(family[0]).checkMember(SON) || mainDB.get(family[0]).checkMember(DAUGHTER)) {
                fullFamiliesList.add(family);
            }
        }
        return fullFamiliesList;
    }

    @Override
    public void addFamily(Integer[] family) {
        familiesList.add(family);
    }

    @Override
    public void addFamilyToCache(Person[] family) {
        Integer[] pair = {family[0].getDbIndex(), family[1].getDbIndex()};
        this.cachedFamilies.add(pair);
    }

    public DataBase(ArrayList<Person> mainDB) {
        this.mainDB = mainDB;
        this.familiesList = new ArrayList<>(2);
        this.cachedFamilies = new ArrayList<>();
    }

    public DataBase() {
        this(new ArrayList<>());
    }

    @Override
    public Iterator<Person> iterator() {
        return new DataBaseIterator(this.mainDB);
    }
}
