package generator;

import classes.Person;
import dataBase.DataBase;

public class GenerationWork {
    private final DataBase mainDb;
    private int generationCount = 0;

    public GenerationWork(DataBase db) {
        this.mainDb = db;
    }

    public GenerationWork() {
        this(new DataBase());
    }

    /* стартовое наполнение */
    public void generatePopulation(int startPopulation){
        this.mainDb.fill(startPopulation);
    }

    public void startGenerator(int count){
        createGeneration(count, mainDb);
    }

    /* генератор поколений */
    private void createGeneration(int count, DataBase db){
        Family generation = new Family();
        generation.createFamilies(db);
        generation.snusnuForEveryOne(db);

        DataBase nextGeneration = new DataBase();
        for (Person[] parents : db.getFullFamilies()) {
            for (Person child : parents[0].getChildren()) {
                nextGeneration.add(child);
            }
        }
        this.mainDb.includeDB(nextGeneration);
        this.mainDb.includeFamilies(db);
        this.generationCount++;
        System.out.printf("Current generation: %d. Population: %d%n", generationCount, mainDb.size());
        System.out.printf("Number of families: %d, general: %d%n", (db.getFullFamilies()).size(), mainDb.getFamiliesNumber());
        System.out.printf("Children: %d\n%n", nextGeneration.size());

        if (generationCount == count) {
            return;
        }
        createGeneration(count, nextGeneration);
    }

}
