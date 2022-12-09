package service.analizator.factory;

import service.analizator.Analizer;
import service.dataBase.DBHandler;

public interface AnalizerFactory {

    Analizer createAnalizer(DBHandler db);
}
