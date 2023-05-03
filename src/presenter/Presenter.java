package presenter;

import model.Service;
import model.person.Human;
import model.person.Person;
import ui.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Presenter {
    private View view;
    private Service<Person> service;


    public Presenter(View view, Service<Person> service) {
        this.view = view;
        this.service = service;
    }

    public String getListPerson() {
        if (service.sizeTree() > 0) {
            StringBuilder result = new StringBuilder();
            for (Person person : service.getSortedListByIdASC()) {
                result.append(person).append("\n");
            }
            return result.toString();
        } else return "В дереве нет персон.";
    }

    public String deletePerson(Integer id) {
        String result;
        if (service.checkID(id)) {
            result = "Удалено: [" + id + "] " + service.getNamePerson(id);
            service.deletePerson(id);
        } else result = "Персона с id = " + id + " отсутствует в дереве.";
        return result;
    }

    public String showTree(Integer id) {
        if (service.checkID(id)) return service.showTree(id);
        else return "Персона с id = " + id + " отсутствует в дереве.";
    }

    public String addPerson(String nameNewPerson, String surnameNewPerson, Date birthDate, Date deathDate,
                            Integer idMother, Integer idFather, Integer idPartner) {
        service.addPerson(new Human(), nameNewPerson, surnameNewPerson, birthDate, deathDate,
                idMother, idFather, idPartner);
        return "Добавлен [" + service.getLastID() + "] " + nameNewPerson;
    }

    public String saveToFile(String fName) {
        service.setFileName(fName);
        try {
            service.saveTree();
            return "Дерево сохранено в файл " + fName + service.getExtensionFiles();
        } catch (IOException ex) {
            return "Не удалось сохранить дерево в файл. Ошибка " + ex;
        }
    }

    public String loadFromFile(Integer number) {
        number--;
        ArrayList<String> listFiles = service.listFiles();
        if (number < listFiles.size()) {
            service.setFileName(listFiles.get(number));
            try {
                service.loadTree();
            } catch (IOException ex) {
                return "Ошибка! Невозможно загрузить файл: " + ex;
            } catch (ClassNotFoundException ex) {
                return "Ошибка! Структура файла не может быть загружена в качестве дерева!";
            }
            return "Дерево загружено из файла: " + listFiles.get(number);
        } else {
            return "Невозможно загрузить файл. Файл не найден.";
        }
    }

    public ArrayList<String> loadFiles() {
        ArrayList<String> listFiles = service.listFiles();
        ArrayList<String> result = new ArrayList<>();
        StringBuilder msg = new StringBuilder();

        if (listFiles.size() > 0) {
            result.add(0, "OK");
            for (int i = 0; i < listFiles.size(); i++) {
                msg.append(i + 1).append(". ").append(listFiles.get(i)).append("\n");
                result.add(1, msg.toString());
            }
        } else {
            result.add(0, "ERROR");
            msg.append("нет файлов для загрузки в каталоге ").append(service.getPathToFile());
            result.add(1, msg.toString());
        }
        return result;
    }

    public String generateSampleTree() {
        service.addPerson(new Human(), "Алексей", "Яковлев",
                new Date(54, Calendar.JANUARY, 1),
                new Date(114, Calendar.JANUARY, 1), null, null, 1);
        service.addPerson(new Human(), "Алевтина", "Яковлева",
                new Date(64, Calendar.FEBRUARY, 2), null, null, null, 0);
        service.addPerson(new Human(), "Борис", "Яковлев",
                new Date(91, Calendar.FEBRUARY, 1), null, 1, 0, 6);
        service.addPerson(new Human(), "Бьянка", "Юргент",
                new Date(92, Calendar.FEBRUARY, 2), null, 1, 0, 7);
        service.addPerson(new Human(), "Богдан", "Яковлев",
                new Date(93, Calendar.MARCH, 3), null, 1, 0, 8);
        service.addPerson(new Human(), "Белла", "Юшкова",
                new Date(94, Calendar.APRIL, 4), null, 1, 0, 9);
        service.addPerson(new Human(), "Белка", "Яковлева",
                new Date(91, Calendar.MAY, 5), null, null, null, 2);
        service.addPerson(new Human(), "Билл", "Юргент",
                new Date(92, Calendar.JUNE, 5), null, null, null, 3);
        service.addPerson(new Human(), "Бибигуль", "Яковлева",
                new Date(93, Calendar.JULY, 5), null, null, null, 4);
        service.addPerson(new Human(), "Булат", "Юшков",
                new Date(94, Calendar.AUGUST, 5), null, null, null, 5);
        service.addPerson(new Human(), "Валера", "Яковлев",
                new Date(111, Calendar.SEPTEMBER, 1), null, 6, 2, null);
        service.addPerson(new Human(), "Виолетта", "Яковлева",
                new Date(112, Calendar.OCTOBER, 1), null, 6, 2, null);
        service.addPerson(new Human(), "Вилор", "Юргент",
                new Date(113, Calendar.NOVEMBER, 2), null, 3, 7, null);
        service.addPerson(new Human(), "Валя", "Юргент",
                new Date(114, Calendar.DECEMBER, 3), null, 3, 7, null);
        service.addPerson(new Human(), "Веня", "Яковлев",
                new Date(115, Calendar.MARCH, 4), null, 8, 4, null);
        service.addPerson(new Human(), "Вера", "Яковлева",
                new Date(116, Calendar.JULY, 5), null, 8, 4, null);
        service.addPerson(new Human(), "Вано", "Юшков",
                new Date(117, Calendar.AUGUST, 6), null, 5, 9, null);
        service.addPerson(new Human(), "Вета", "Юшкова",
                new Date(118, Calendar.SEPTEMBER, 7), null, 5, 9, null);

        return "Дерево сгенерировано.";
    }
}