package generator;

import classes.Person;
import dataBase.DataBase;

public class GetRandom {
    public static Person getRandomParent(DataBase db) {
        return db.getRandomPerson();
    }

    public static Person getRandomChild(DataBase db) {
        return db.getRandomChild();
    }

    public static Person[] getRandomFamily(DataBase db) {
        return db.getRandomFamily();
    }
}
