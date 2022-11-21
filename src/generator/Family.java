package generator;

import dataBase.DataBase;
import classes.Human;
import classes.Parent;

import java.io.IOException;
import java.util.ArrayList;

import static classes.Human.marige.NO;
import static classes.Human.marige.YES;
import static classes.Human.state.FEMALE;
import static classes.Human.state.MALE;

public class Family {
    /**
     * создание семьи
     *
     * @param human    - первый человек
     * @param humanSec - второй человек
     * @param db       - база данных
     */
    public static void marige(Human human, Human humanSec, DataBase db) {
        switch (human.getGender()) {
            case MALE -> humanSec.setFamilyname(human.getFamilyname());
            case FEMALE -> human.setFamilyname(humanSec.getFamilyname());
        }
        db.addFamily(human, humanSec);
        human.setMarigeStatus(YES);
        humanSec.setMarigeStatus(YES);
    }

    /* размножаем людей */
    public static void snusnuForEveryOne(DataBase db) throws IOException {
        for (Human[] pair : db.showFamilies()) {
            snusnuResults(pair, db);
        }
    }

    /* результаты размножения */
    public static void snusnuResults(Human[] pair, DataBase db) throws IOException {
        int childrenNumber = childrenGenerator();
        int familyIndex = db.getFamilyIndex(pair);
        Human human = pair[0];
        Human humanSec = pair[1];
        if (childrenNumber != 0) {
            Parent parent1 = changeType(human, db);
            Parent parent2 = changeType(humanSec, db);
            chengeChildType(human, parent1);
            chengeChildType(humanSec, parent2);
            for (int i = 1; i <= childrenNumber; i++) {
                createChild(parent1, parent2);
            }
            db.replaceFamily(parent1, parent2, familyIndex);
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

    /**
     * переписываем в базе объект Human на объект Parent
     *
     * @param old    - старый
     * @param newOne - новый
     */
    private static void chengeChildType(Human old, Parent newOne) {
        for (Parent parent : old.getParents()) {
            if (parent == null) {
                return;
            } else {
                parent.replaceChild(old, newOne);
            }
        }
    }

    /**
     * переписываем в базе объект Human на объект Parent
     *
     * @param person - Human объект для перезаписи
     * @param db     - база
     * @return - полная копия объекта Human в Person
     */
    private static Parent changeType(Human person, DataBase db) {
        Parent personNew = new Parent(person);
        db.replace(person, personNew);
        return personNew;
    }

    /* создаём и везде прописываем дитя */
    private static void createChild(Parent parent1, Parent parent2) throws IOException {
        new Human();
        Human child = switch (parent1.getGender()) {
            case MALE -> Generator.create(parent1.getFamilyname());
            case FEMALE -> Generator.create(parent2.getFamilyname());
        };
        parent1.addChild(child);
        parent2.addChild(child);
        Parent[] parents = {parent1, parent2};
        child.setParents(parents);
    }

    /* создаём семью */
    public static void createFamily(DataBase db) {
        ArrayList<Human> target;
        ArrayList<Human> males = db.getListOf(MALE);
        ArrayList<Human> females = db.getListOf(FEMALE);
        if (males.size() > females.size()) {
            target = females;
        } else {
            target = males;
        }
        for (Human human : target) {
            prepairCouple(human, db);
        }
    }

    /* подготовка */
    private static void prepairCouple(Human human, DataBase db) {
        if (human.getMarigeStatus() != YES) {
            switch (human.getGender()) {
                case MALE -> marige(human, check(db, FEMALE), db);
                case FEMALE -> marige(human, check(db, MALE), db);
            }
        }
    }

    /* подбор людей */
    private static Human check(DataBase db, Human.state state) {
        int index = Generator.rand.nextInt(0, db.size());
        Human human = db.get(index);
        if (human.getGender() == state) {
            if (human.getMarigeStatus() == NO) {
                return human;
            }
        }
        human = check(db, state);
        return human;
    }
}
