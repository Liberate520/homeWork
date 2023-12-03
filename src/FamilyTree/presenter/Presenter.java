package FamilyTree.presenter;

import FamilyTree.model.Person.Gender;
import FamilyTree.model.Service.Service;
import FamilyTree.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter {
    private View view;
    private Service service;

    // Конструктор класса
    public Presenter (View view){
        this.view = view;
        this.service = new Service();
    }

    // Функция получения Дерева в виде строки
    public void getTree() {
        String str = service.getTree().toString();
        view.answer(str);
    }

    // Добавление человека в дерево
    public void addPerson(String name, String surname, String gender, String birthday) {
        Gender gen;
        if (gender.equals("Ж")){ gen = Gender.woman;}
        else {gen = Gender.man;}

        LocalDate date = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy MM dd"));

        service.addPerson(name, surname, gen, date);
        getTree();
    }

    // Соединение 2х людей
    public void setMarriage(int idP1, int idP2, String date){ service.setMarriage(idP1, idP2, date); }

    // Сортировки
    public void sortByName() {
        service.sortByName();
        getTree();
    }

    public void sortByAge() {
        service.sortByAge();
        getTree();
    }

    // Работа с файлом
    public void saveTree(String filename) {
        service.saveTreeInFile(filename);
    }

    public void loadTree(String filename) {
        service.loadFromFile(filename);
    }



}
