import java.util.ArrayList;
import java.util.List;

public class GeoTree {
    private List<Person> personList;

    public GeoTree() {
        this(new ArrayList<>());
    }

    public GeoTree(List<Person> personList) {
        this.personList = personList;
    }

    /**
     * Метод, который добовляет связи предков и наследников, а также является
     * флагом для предотращения ошибки, если такой человек есть и его нельзя
     * добавить в список
     * 
     * @param person - личность претендующая на родство
     * @return - успех проведенной проверки
     */
    public boolean addPerson(Person person) {

        if (person == null) {
            return false;
        }

        if (!personList.contains(person)) {
            personList.add(person);

            if (person.getFather() != null) {
                person.getFather().addChild(person);
            }

            if (person.getMother() != null) {
                person.getMother().addChild(person);
            }
            return true;
        }
        return false;
    }

    /**
     * Метод для поиска в списке лисчности по ФИО
     * 
     * @param name       - имя;
     * @param surname    - фамилия;
     * @param patronymic - отчество;
     * @return - возвращает личность или null, если такого нет в списке
     */
    public Person getByName(String name, String surname, String patronymic) {

        for (Person person : personList) {

            if ((person.getName().equals(name)) &&
                    (person.getSurname().equals(surname)) &&
                    (person.getPatronymic().equals(patronymic))) {
                return person;
            }
        }
        return null;
    }

    /**
     * Вывод информации об объекте генеологическое дерево строкой
     * 
     * @return - toString
     */
    public String getInfo() {
        StringBuilder sInfo = new StringBuilder();
        sInfo.append("В дереве ");
        sInfo.append(personList.size());
        sInfo.append(" объектов: \n");
        for (Person person : personList) {
            sInfo.append(person.getInfo());
            sInfo.append("\n");
        }
        return sInfo.toString();
    }

}
