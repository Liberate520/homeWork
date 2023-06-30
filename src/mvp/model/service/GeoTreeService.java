package mvp.model.service;

import java.time.LocalDate;

import mvp.model.geoTree.GeoTree;
import mvp.model.geoTree.workGeoTreeData.Writable;
import mvp.model.person.Person;

public class GeoTreeService extends GeoTree<Person>{
    private Writable writable;
    private final String filePath = "src/mvp/model/data/tree.txt";
    private GeoTree<Person> activeGeoTree;

    public GeoTreeService(GeoTree<Person> activeGeoTree) {
        this.activeGeoTree = activeGeoTree;
    }

    public GeoTreeService() {
        activeGeoTree = new GeoTree<>();
    }

    public boolean write() {
        if (writable == null) {
            return false;
        }
        return writable.write(activeGeoTree, filePath);
    }

    public boolean read() {
        if (writable == null) {
            return false;
        }
        activeGeoTree = (GeoTree<Person>) writable.read(filePath);
        if (activeGeoTree == null) {
            activeGeoTree = new GeoTree<>();
        }
        return true;
    }

    public String addPerson(
            String name,
            String surname,
            String patronymic,
            LocalDate dateOfBirth,
            Person father,
            Person mother) {

        Person personFather = null;

        if (!father.equals("")) {
            personFather = activeGeoTree.getByName(name, surname, patronymic);
        }
        if (personFather == null) {
            return "Отец не найден";
        }
        // LocalDate personBirthDate = LocalDate.parse((String)dateOfBirth);
        
        return "Операция по добавлению выполнена";

    }

    public Person getByName(String name, String surname, String patronymic) {

        for (Person person : activeGeoTree) {

            if ((person.getName().equals(name)) &&
                    (person.getSurname().equals(surname)) &&
                    (person.getPatronymic().equals(patronymic))) {
                return person;
            }
        }
        return null;
    }

}
