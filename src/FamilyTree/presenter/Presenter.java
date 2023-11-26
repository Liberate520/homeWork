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

        service.addPerson(service.builder.build(name, surname, gen, date));
        getTree();
        //view.answer("ок, добавили");
    }

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
    public void saveTree() {
        service.saveTreeInFile();
    }

    public void loadTree() {
        service.loadFromFile();
    }
}
