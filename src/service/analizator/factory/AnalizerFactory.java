package service.analizator.factory;

import service.analizator.Analizer;
import service.analizator.DBAnalizer;
import service.analizator.ExtendedPersonAnalizer;
import service.analizator.PersonAnalizer;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;
import service.generator.GetRandom;

public class AnalizerFactory {
    public static Analizer giveAnalizer(String param) {
        DBHandler db = DataBase.getDB();
        return switch (param) {
            case "DB" -> new DBAnalizer(db);
            case "Person" -> new PersonAnalizer(GetRandom.getRandomPerson(db), db);
            case "ExPerson" -> new ExtendedPersonAnalizer(GetRandom.getRandomPerson(db), db);
            default -> null;
        };
    }
}
