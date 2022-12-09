package service.generator;

import service.classes.Person;
import service.dataBase.DBHandler;
import service.tree.RelationType;

import java.util.ArrayList;

import static service.classes.Gender.*;
import static service.tree.RelationType.*;

/*
Класс для генерации детей в базе
 */
public class ChildrenGenerator {
    private final DBHandler db;
    private final int generation;

    public ChildrenGenerator(DBHandler db, int generation) {
        this.generation = generation;
        this.db = db;
    }

    public void snusnuForEveryOne() {
        for (Integer[] pair : db.getCachedFamilies()) {
            snusnuResults(pair);
        }
    }

    /* результаты размножения */
    private void snusnuResults(Integer[] pair) {
        int childrenCount = childrenGenerator();
        Person parent1 = db.getPerson(pair[0]);
        Person parent2 = db.getPerson(pair[1]);
        if (childrenCount != 0) {
            for (int i = 1; i <= childrenCount; i++) {
                createChild(parent1, parent2);
            }
            if (childrenCount > 1) {
                ArrayList<Integer> children = parent1.getChildren();
                for (Integer childIndex : children) {
                    for (Person member : db.getPersons(children)) {
                        if (!equals(member, db.getPerson(childIndex))) {
                            RelationType type = member.getGender() == MALE ? BROTHER : SISTER;
                            db.getPerson(childIndex).addMember(type, member);
                        }
                    }
                }
            }
        }
    }

    private boolean equals(Person obj1, Person obj2) {
        return obj1.hashCode() == obj2.hashCode();
    }

    /*
    вероятность появления детей у пары
     */
    private static int childrenGenerator() {
        int chance = PersonGenerator.rand.nextInt(0, 100);
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
    private void createChild(Person parent1, Person parent2) {
        Person child = new Person();
        switch (parent1.getGender()) {
            // проверяем фамилию
            case MALE -> {
                child = PersonGenerator.create(parent1.getFamilyname());
                child.setGeneration(this.generation);
                db.addPerson(child);
                addFamilyMembers(child, parent1, parent2);
            }
            case FEMALE -> {
                child = PersonGenerator.create(parent2.getFamilyname());
                child.setGeneration(this.generation);
                db.addPerson(child);
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
    private void addFamilyMembers(Person child, Person parent1, Person parent2) {
        child.addMember(FATHER, parent1);
        if (parent1.checkMember(FATHER)) {
            child.addMember(GRANDFATHER, db.getPerson(parent1.getMember(FATHER).get(0)));
            child.addMember(GRANDMOTHER, db.getPerson(parent1.getMember(MOTHER).get(0)));
        }
        child.addMember(MOTHER, parent2);
        if (parent2.checkMember(FATHER)) {
            child.addMember(GRANDFATHER, db.getPerson(parent2.getMember(FATHER).get(0)));
            child.addMember(GRANDMOTHER, db.getPerson(parent2.getMember(MOTHER).get(0)));
        }
    }
}
