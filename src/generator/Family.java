package generator;

import classes.Gender;
import classes.Parent;
import dataBase.DataBase;

import java.util.ArrayList;

import static classes.Gender.FEMALE;
import static classes.Gender.MALE;
import static classes.Marrige.NO;
import static classes.Marrige.YES;

public class Family {
    /**
     * создание семьи
     *
     * @param person    - первый человек
     * @param personSec - второй человек
     * @param db       - база данных
     */
    private void marige(Parent person, Parent personSec, DataBase db) {
        switch (person.getGender()) {
            case MALE -> personSec.setFamilyname(person.getFamilyname());
            case FEMALE -> person.setFamilyname(personSec.getFamilyname());
        }
        db.addFamily(person, personSec);
        person.setMarigeStatus(YES);
        personSec.setMarigeStatus(YES);
    }

    /* размножаем людей */
    public void snusnuForEveryOne(DataBase db){
        for (Parent[] pair : db.showFamilies()) {
            snusnuResults(pair);
        }
    }

    /* результаты размножения */
    private void snusnuResults(Parent[] pair){
        int childrenNumber = childrenGenerator();
        Parent parent1 = pair[0];
        Parent parent2 = pair[1];
        if (childrenNumber != 0) {
            for (int i = 1; i <= childrenNumber; i++) {
                createChild(parent1, parent2);
            }
        }
    }

    /*
    вероятность появления детей у пары
     */
    private static int childrenGenerator() {
        int chance = Generator.rand.nextInt(0, 100);
        int childrenNumber = 0;
        if (chance < 50 && chance > 25) {
            childrenNumber = 1;
        } else if (chance < 80 && chance > 50) {
            childrenNumber = 2;
        } else if (chance > 80) {
            childrenNumber = 3;
        }
        return childrenNumber;
    }

//    /**
//     * переписываем в базе объект Human на объект Parent
//     *
//     * @param old    - старый
//     * @param newOne - новый
//     */
//    private static void chengeChildType(Parent old, Parent newOne) {
//        for (Parent parent : old.getParents()) {
//            if (parent == null) {
//                return;
//            } else {
//                parent.replaceChild(old, newOne);
//            }
//        }
//    }

//    /**
//     * переписываем в базе объект Human на объект Parent
//     *
//     * @param person - Human объект для перезаписи
//     * @param db     - база
//     * @return - полная копия объекта Human в Person
//     */
//    private static Parent changeType(Parent person, DataBase db) {
//        Parent personNew = new Parent(person);
//        db.replace(person, personNew);
//        return personNew;
//    }

    /* создаём и везде прописываем дитя */
    private void createChild(Parent parent1, Parent parent2){
        new Parent();
        Parent child = switch (parent1.getGender()) {
            case MALE -> Generator.create(parent1.getFamilyname());
            case FEMALE -> Generator.create(parent2.getFamilyname());
        };
        parent1.addChild(child);
        parent2.addChild(child);
        Parent[] parents = {parent1, parent2};
        child.setParents(parents);
    }

    /* создаём семью */
    public void createFamilies(DataBase db) {
        ArrayList<Parent> target;
        ArrayList<Parent> males = db.getListOf(MALE);
        ArrayList<Parent> females = db.getListOf(FEMALE);
        if (males.size() > females.size()) {
            target = females;
        } else {
            target = males;
        }
        for (Parent parent : target) {
            prepairCouple(parent, db);
        }
    }

    /* подготовка */
    private void prepairCouple(Parent person, DataBase db) {
        if (person.getMarigeStatus() != YES) {
            switch (person.getGender()) {
                case MALE -> marige(person, check(db, FEMALE), db);
                case FEMALE -> marige(person, check(db, MALE), db);
            }
        }
    }

    /* подбор людей */
    private Parent check(DataBase db, Gender state) {
        int index = Generator.rand.nextInt(0, db.size());
        Parent person = db.get(index);
        if (person.getGender() == state) {
            if (person.getMarigeStatus() == NO) {
                return person;
            }
        }
        person = check(db, state);
        return person;
    }
}
