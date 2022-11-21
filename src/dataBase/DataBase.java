package dataBase;

import classes.Human;
import classes.Human.state;
import classes.Parent;
import generator.Generator;

import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    ArrayList<Human> db;
    ArrayList<Human[]> familiesList;

    public void showBase() {
        for (Human human : db) {
            human.getInfo();
        }
    }

    public Human get(int index) {
        return db.get(index);
    }

    public Parent getRandomParent() {
        int index = Generator.rand.nextInt(0, db.size());
        Human human = this.db.get(index);
        if (human instanceof Parent) {
            return (Parent) human;
        }
        human = getRandomParent();
        return (Parent) human;
    }

    public Human getRandomChild() {
        int index = Generator.rand.nextInt(0, db.size());
        Human human = this.db.get(index);
        if (human.getParents()[0] != null) {
            return human;
        }

        human = getRandomParent();
        return human;
    }

    public Human[] getRandomFamily() {
        int index = Generator.rand.nextInt(0, familiesList.size());
        return familiesList.get(index);
    }

    public int size() {
        return db.size();
    }

    /*
    возвращает список записей имеющих определённый статус гендера
     */
    public ArrayList<Human> getListOf(state state) {
        ArrayList<Human> results = new ArrayList<>();
        for (Human human : db) {
            if (human.getGender() == state) {
                results.add(human);
            }
        }
        return results;
    }

    public ArrayList<Human> getDb() {
        return db;
    }

    /*
     * заполнить базу
     */
    public void fill(int quantity) throws IOException {
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
    добавляет другие семьи
     */
    public void includeFamilies(DataBase nextGeneration) {
        this.familiesList.addAll(nextGeneration.getFullFamilies());
    }

    public void add(Human person) {
        db.add(person);
    }

    /* Замена человека в базе */
    public void replace(Human old, Human newOne) {
        db.set(db.indexOf(old), newOne);
    }

    /* замена семьи в базе */
    public void replaceFamily(Parent parent1, Parent parent2, int index) {
        Human[] family = {parent1, parent2};
        familiesList.set(index, family);
    }

    /* Индекс семьи */
    public int getFamilyIndex(Human[] pair) {
        return familiesList.indexOf(pair);
    }

    public void addFamily(Human husband, Human wife) {
        Human[] pair = new Human[2];
        pair[0] = husband;
        pair[1] = wife;
        familiesList.add(pair);
    }

    public ArrayList<Human[]> showFamilies() {
        return familiesList;
    }

    /* количество семей в базе */
    public int getFamiliesNumber() {
        return familiesList.size();
    }

    public ArrayList<Human[]> getFullFamilies() {
        ArrayList<Human[]> fullFamiliesList = new ArrayList<>();
        for (Human[] family : familiesList) {
            if (family[0] instanceof Parent) {
                fullFamiliesList.add(family);
            }
        }
        return fullFamiliesList;
    }


    public DataBase(ArrayList<Human> db) {
        this.db = db;
        this.familiesList = new ArrayList<>(2);
    }

    public DataBase() {
        this(new ArrayList<>());
    }
}
