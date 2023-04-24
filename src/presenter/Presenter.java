package presenter;

import model.Service;
import person.Human;
import person.Person;
import ui.View;

import java.util.Date;

public class Presenter {
    private View view;
    private Service<Person> service;


    public Presenter(View view, Service<Person> service) {
        this.view = view;
        this.service = service;
    }

    public String getListPerson() {
        StringBuilder result = new StringBuilder();
        for (Person person : service.getSortedListByIdASC()) {
            result.append(person).append("\n");
        }
        return result.toString();
    }

    public String deletePerson(Integer id) {
        String result = "Удалено: [" + id + "] " + service.getNamePerson(id);
        service.deletePerson(id);
        return result;
    }

    public String showTree(Integer id) {
        return service.showTree(id);
    }

    public String addPerson(String nameNewPerson, String surnameNewPerson, Date birthDate, Date deathDate,
                            Integer idMother, Integer idFather, Integer idPartner) {
        service.addPerson(new Human(), nameNewPerson, surnameNewPerson, birthDate, deathDate,
                idMother, idFather, idPartner);
        return "Добавлен [" + service.getLastID() + "] " + nameNewPerson;
    }
}
