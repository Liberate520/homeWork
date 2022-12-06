package service.analizator;

import service.classes.Person;
import service.dataBase.DBHandler;

import static service.classes.Gender.MALE;
import static service.classes.Marrige.YES;

public class DBAnalizer implements Analizer {

    private String stats;

    private final DBHandler db;

    /*
    собирает общую статистику по базе
     */
    public void getDBStats() {
        StatWorker line = new StatWorker();
        int married = 0;
        int single = 0;
        int man = 0;
        int woman = 0;
        for (Person person : this.db) {
            if (person.getMarigeStatus() == YES) {
                married++;
            } else {
                single++;
            }
            if (person.getGender() == MALE) {
                man++;
            } else {
                woman++;
            }
        }
        line.addPosition("Size of DB = " + this.db.getDb().size() + "\n");
        line.addPosition("Number of families: " + this.db.getFullFamilies().size() + "\n");
        line.addPosition("Number of married people: " + married + "\n");
        line.addPosition("Number of single people: " + single + "\n");
        line.addPosition("Number of man: " + man + "\n");
        line.addPosition("Number of woman: " + woman + "\n");
        this.stats = line.toString();
    }

    @Override
    public String getStats() {
        return this.stats;
    }

    public DBAnalizer(DBHandler db){
        this.db = db;
    }
}
