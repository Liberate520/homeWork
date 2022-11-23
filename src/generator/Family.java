package generator;

import classes.Gender;
import classes.Parent;
import dataBase.DataBase;
import tree.RelationType;

import java.util.ArrayList;

import static tree.RelationType.*;
import static classes.Gender.*;
import static classes.Marrige.*;

public class Family {
    /**
     * создание семьи
     *
     * @param person    - первый человек
     * @param personSec - второй человек
     * @param db        - база данных
     */
    private void marige(Parent person, Parent personSec, DataBase db) {
        switch (person.getGender()) {
            case MALE -> {
                personSec.setFamilyname(person.getFamilyname());
                person.addMember(WIFE, personSec);
                personSec.addMember(HUSBAND, person);
            }
            case FEMALE -> {
                person.setFamilyname(personSec.getFamilyname());
                person.addMember(HUSBAND, personSec);
                personSec.addMember(WIFE, person);
            }
        }
        db.addFamily(person, personSec);
        person.setMarigeStatus(YES);
        personSec.setMarigeStatus(YES);
    }

    /* размножаем людей */
    public void snusnuForEveryOne(DataBase db) {
        for (Parent[] pair : db.showFamilies()) {
            snusnuResults(pair);
        }
    }

    /* результаты размножения */
    private void snusnuResults(Parent[] pair) {
        int childrenCount = childrenGenerator();
        Parent parent1 = pair[0];
        Parent parent2 = pair[1];
        if (childrenCount != 0) {
            for (int i = 1; i <= childrenCount; i++) {
                createChild(parent1, parent2);
            }
            if (childrenCount > 1) {
                ArrayList<Parent> children = parent1.getChildren();
                for (Parent child : children) {
                    for (Parent member : children) {
                        if (!equals(member, child)) {
                            RelationType type = member.getGender() == MALE ? BROTHER : SISTER;
                            child.addMember(type, member);
                        }
                    }
                }
            }
        }
    }

    private boolean equals(Parent obj1, Parent obj2) {
        return obj1.hashCode() == obj2.hashCode();
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


    /* создаём и везде прописываем дитя */
    private void createChild(Parent parent1, Parent parent2) {

        Parent child = new Parent();
        switch (parent1.getGender()) {
            // проверяем фамилию
            case MALE -> {
                child = Generator.create(parent1.getFamilyname());
                addFamilyMembers(child, parent1, parent2);
            }
            case FEMALE -> {
                child = Generator.create(parent2.getFamilyname());
                addFamilyMembers(child, parent2, parent1);
            }
        }
        // добавляем ребёнка родителям
        switch (child.getGender()) {
            case MALE -> {
                parent1.addMember(SON, child);
                parent2.addMember(SON, child);
            }
            case FEMALE -> {
                parent1.addMember(DAUGHTER, child);
                parent2.addMember(DAUGHTER, child);
            }
        }
    }

    /*
    добавляем членов семьи с проверкой
     */
    private void addFamilyMembers(Parent child, Parent parent1, Parent parent2) {
        child.addMember(FATHER, parent1);
        if (parent1.checkMember(FATHER)) {
            child.addMember(GRANDFATHER, parent1.getMember(FATHER).get(0));
            child.addMember(GRANDMOTHER, parent1.getMember(MOTHER).get(0));
        }
        child.addMember(MOTHER, parent2);
        if (parent2.checkMember(FATHER)) {
            child.addMember(GRANDFATHER, parent2.getMember(FATHER).get(0));
            child.addMember(GRANDMOTHER, parent2.getMember(MOTHER).get(0));
        }
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
