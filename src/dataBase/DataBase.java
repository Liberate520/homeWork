package dataBase;

import classes.Gender;
import classes.Marrige;
import classes.Parent;
import generator.Generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import static tree.RelationType.FATHER;

public class DataBase implements Serializable, Iterable<Parent> {
    private ArrayList<Parent> db;
    private ArrayList<Parent[]> familiesList;

    public void showBase() {
        for (Parent person : db) {
            person.getInfo();
        }
    }

    public Parent get(int index) {
        return db.get(index);
    }

    public Parent getRandomParent() {
        int index = Generator.rand.nextInt(0, db.size());
        Parent parent = this.db.get(index);
        if (!parent.getChildren().isEmpty()) {
            return parent;
        }
        parent = getRandomParent();
        return parent;
    }

    public Parent getRandomChild() {
        int index = Generator.rand.nextInt(0, db.size());
        Parent child = this.db.get(index);
        if (child.getMember(FATHER) != null) {
            return child;
        }

        child = getRandomParent();
        return child;
    }

    public Parent[] getRandomFamily() {
        int index = Generator.rand.nextInt(0, familiesList.size());
        return familiesList.get(index);
    }

    public Parent[] getFamily(int index) {
        return familiesList.get(index);
    }

    public int size() {
        return db.size();
    }

    /*
    возвращает список записей имеющих определённый статус гендера
     */
    public ArrayList<Parent> getListOf(Gender state) {
        ArrayList<Parent> results = new ArrayList<>();
        for (Parent person : db) {
            if (person.getGender() == state) {
                results.add(person);
            }
        }
        return results;
    }

    public ArrayList<Parent> getListOf(Marrige state) {
        ArrayList<Parent> results = new ArrayList<>();
        for (Parent person : db) {
            if (person.getMarigeStatus() == state) {
                results.add(person);
            }
        }
        return results;
    }

    public ArrayList<Parent> getDb() {
        return db;
    }

    /*
     * заполнить базу
     */
    public void fill(int quantity) {
        for (int i = 0; i < quantity; i++) {
            db.add(Generator.create());
        }
    }

    /*
    добавляет другую db
     */
    public void includeDB(DataBase nextGeneration) {
        this.db.addAll(nextGeneration.getDb());
        this.familiesList.addAll(nextGeneration.getFullFamilies());
    }

    /*
    добавляет семьи из другой базы
     */
    public void includeFamilies(DataBase nextGeneration) {
        this.familiesList.addAll(nextGeneration.getFullFamilies());
    }

    public void add(Parent person) {
        db.add(person);
    }

    /* Замена человека в базе */
    public void replace(Parent old, Parent newOne) {
        db.set(db.indexOf(old), newOne);
    }

    /* замена семьи в базе */
    public void replaceFamily(Parent parent1, Parent parent2, int index) {
        Parent[] family = {parent1, parent2};
        familiesList.set(index, family);
    }

    /* Индекс семьи */
    public int getFamilyIndex(Parent[] pair) {
        return familiesList.indexOf(pair);
    }

    public void addFamily(Parent person, Parent personSec) {
        Parent[] pair = new Parent[2];
        pair[0] = person;
        pair[1] = personSec;
        familiesList.add(pair);
    }

    public ArrayList<Parent[]> getFamilies() {
        return familiesList;
    }

    /* количество семей в базе */
    public int getFamiliesNumber() {
        return familiesList.size();
    }

    public ArrayList<Parent[]> getFullFamilies() {
        ArrayList<Parent[]> fullFamiliesList = new ArrayList<>();
        for (Parent[] family : familiesList) {
            if (family[0] != null) {
                fullFamiliesList.add(family);
            }
        }
        return fullFamiliesList;
    }

    public DataBase(ArrayList<Parent> db) {
        this.db = db;
        this.familiesList = new ArrayList<>(2);
    }

    public DataBase() {
        this(new ArrayList<>());
    }

    @Override
    public Iterator iterator() {
        return new ParentIterator(this.db);
    }
}
