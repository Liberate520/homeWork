package service.generator;

import service.classes.Person;
import service.dataBase.DBHandler;

/*
Класс - генератор случайного Person из базы
 */
public class GetRandom {

    public static Person getRandomPerson(DBHandler db) {
        int index = PersonGenerator.rand.nextInt(0, db.getSize());
        return db.getPerson(index);
    }
}
