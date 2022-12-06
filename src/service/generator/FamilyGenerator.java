package service.generator;

import service.classes.Gender;
import service.classes.Person;
import service.dataBase.DBHandler;

import java.util.ArrayList;

import static service.classes.Gender.*;
import static service.classes.Marrige.*;
import static service.tree.RelationType.HUSBAND;
import static service.tree.RelationType.WIFE;

/*
Класс для генерации семейных пар в базе
 */
public class FamilyGenerator {


    /* создаём семью */
    public void createFamilies(DBHandler db) {
        ArrayList<Person> target;
        ArrayList<Person> males = db.getListOf(MALE);
        ArrayList<Person> females = db.getListOf(FEMALE);
        if (males.size() > females.size()) {
            target = females;
        } else {
            target = males;
        }
        for (Person parent : target) {
            prepairCouple(parent, db);
        }
    }

    /* подготовка */
    private void prepairCouple(Person person, DBHandler db) {
        if (person.getMarigeStatus() != YES) {
            switch (person.getGender()) {
                case MALE -> marige(person, check(db, FEMALE), db);
                case FEMALE -> marige(person, check(db, MALE), db);
            }
        }
    }

    /* подбор людей */
    private Person check(DBHandler db, Gender state) {
        Person person = GetRandom.getRandomPerson(db);
        if (person.getGender() == state) {
            if (person.getMarigeStatus() == NO) {
                return person;
            }
        }
        person = check(db, state);
        return person;
    }

    /**
     * создание семьи
     *
     * @param person    - первый человек
     * @param personSec - второй человек
     * @param db        - база данных
     */
    private void marige(Person person, Person personSec, DBHandler db) {
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
        Person[] pair = {person, personSec};
        db.addFamily(pair);
        person.setMarigeStatus(YES);
        personSec.setMarigeStatus(YES);
    }
}
