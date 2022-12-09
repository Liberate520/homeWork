package service.generator;

import service.analizator.StatWorker;
import service.classes.Person;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;

import java.util.Date;

/*
Класс - генератор поколений
 */
public class GenerationWork {
    private final DBHandler mainDb;
    private String stats;
    StatWorker line = new StatWorker();
    private int generationCount = 1;

    /* стартовое поколение */
    public void generatePopulation(int startPopulation) {
        this.mainDb.fill(startPopulation);
    }

    public void startGenerator(int count) {
        createGeneration(count);
        line.addPosition("Date of generation: " + mainDb.getCreationDate().toString());
        this.stats = line.toString();
    }

    /* генератор поколений */
    private void createGeneration(int count) {
        long startTime = System.nanoTime();
        FamilyGenerator familyGeneration = new FamilyGenerator(mainDb, this.generationCount - 1);
        ChildrenGenerator childrenGeneration = new ChildrenGenerator(mainDb, this.generationCount);
        familyGeneration.createFamilies();
        childrenGeneration.snusnuForEveryOne();
//
//        for (Person person : mainDb.getGeneration(this.generationCount)) {
//            this.mainDb.addChild(person);
//        }

        mainDb.familiesCacheFlush();
        line.addPosition("Current generation: " + generationCount
                + ". Population: " + mainDb.getSize() + "\n");
        line.addPosition("Families with children: " + mainDb.getFullFamilies().size()
                + ", general: " + mainDb.getFamiliesNumber() + "\n");
        line.addPosition("Children: " + mainDb.getChildrenSize(generationCount) + "\n");
        line.addPosition("Time for generation generation = "
                + (System.nanoTime() - startTime) + "ns" + "\n" + "\n");
        this.generationCount++;
        if (generationCount == count) {
            return;
        }
        createGeneration(count);
        this.mainDb.setCreationDate(new Date());
    }

    public String getStats() {
        return this.stats;
    }

    public GenerationWork(DBHandler db) {
        this.mainDb = db;
    }
}
