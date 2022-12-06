package service.generator;

import service.classes.Person;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;

import static service.tree.RelationType.FATHER;

public class GetRandom {

    public static Person getRandomPerson(DBHandler db) {
        int index = Generator.rand.nextInt(0, db.getSize());
        return db.get(index);
    }
    public static Person getRandomParent(DBHandler db) {
        int index = Generator.rand.nextInt(0, db.getSize());
        Person parent = db.get(index);
        if (!parent.getChildren().isEmpty()) {
            return parent;
        }
        parent = getRandomParent(db);
        return parent;
    }

    public static Person getRandomChild(DBHandler db) {
        int index = Generator.rand.nextInt(0, db.getSize());
        Person child = db.get(index);
        if (child.getMember(FATHER) != null) {
            return child;
        }
        child = getRandomChild(db);
        return child;
    }

    public static Person[] getRandomFamily(DBHandler db) {
        int index = Generator.rand.nextInt(0, db.getFamiliesNumber());
        return db.getFamily(index);
    }
}
