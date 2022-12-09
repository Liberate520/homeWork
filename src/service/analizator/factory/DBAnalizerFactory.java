package service.analizator.factory;

import service.analizator.Analizer;
import service.analizator.DBAnalizer;
import service.dataBase.DBHandler;

public class DBAnalizerFactory implements AnalizerFactory{
    @Override
    public Analizer createAnalizer(DBHandler db) {
        return new DBAnalizer(db);
    }
}
