package model.service;

import model.familyTree.ConnectionType;
import model.familyTree.Connections;
import model.familyTree.FamilyTree;
import model.person.Gender;
import model.person.Person;
import model.readWrite.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Service {
    private FamilyTree<Person> tree;
    private FileHandler fileHandler;

    public Service() {
        this.tree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public void addPerson(String name,
                          String surname,
                          String patronymic,
                          Gender gender,
                          LocalDate dateBirth,
                          LocalDate dateDeath) {
        tree.addPerson(new Person(name, surname, patronymic, gender, dateBirth, dateDeath));
    }

    public void oneWayConnection(Person connectFrom, ConnectionType key, Person connectTo) {
        tree.oneWayConnection(connectFrom, key, connectTo);
    }

    public void putConnection(Person connectFrom, ConnectionType key, Person connectTo) {
        tree.putConnection(connectFrom, key, connectTo);
    }

    public String showConnections(Person person) {
        return tree.showConnections(person);
    }

    public String sortByAge() {
        return tree.sortByAge();
    }

    public String sortByName() {
        return tree.sortByName();
    }

    public String printTreeConnections() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Person, Connections<Person>> item :
                tree) {
            sb.append(showConnections(item.getKey())).append("\n");
        }
        if (sb.toString().isBlank())
            return "Список пока пуст. Попробуйте загрузить из файла, или добавить людей.\n";
        return sb.toString();
    }

    public String printTree() {
        if (tree.toString().isBlank())
            return "Список пока пуст. Попробуйте загрузить из файла, или добавить людей.\n";
        return tree.toString();
    }

    public ArrayList<Person> enumeratedList() {
        ArrayList<Person> result = new ArrayList<>();
        for (Map.Entry<Person, Connections<Person>> pair :
                tree) {
            Person item = pair.getKey();
            result.add(item);
        }
        return result;
    }

    public void write() {
        fileHandler.write(tree);
    }

    public void read() {
        this.tree = (FamilyTree<Person>) fileHandler.read();
    }
}
