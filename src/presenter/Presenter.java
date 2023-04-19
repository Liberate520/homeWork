package presenter;

import tree.Service;
import view.View;

public class Presenter {
    View view;
    Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
    }

    public void addMember(String name, String FatherName, String MatherName) {
        if (service.addMember(name, FatherName, MatherName)) {
            view.print(service.find(name) + "  успешно добавлен");
        } else view.print("Добавление не  удалось");
    }

    public String getName(String name) {
        return service.find(name).getName();
    }

    public String getInfo() {
        return service.getInfo();
    }

    public void getChildren(String nameFather) {
        view.print(service.getChildren(nameFather));
    }

    public boolean findMember(String name) {
        if (service.find(name) != null) {
            view.print(service.find(name).getInfo());
            return true;
        } else view.print("Такой человек не найден");
        return false;
    }

    public void editName(String name, String newName) {
        if (service.editName(name, newName)) {
            view.print(name + " стал " + newName);
        } else view.print("Такой человек не найден");
    }
    public void editYearBirth(String name,int yearBirth)
    {
        if(service.editYearBirth(name,yearBirth))
        {
            view.print("Год рождения изменен на "+ yearBirth);
        }
        else view.print("Такой человек не найден");
    }
    public void editYearDeath(String name,int yearDeath)
    {
        if(service.editYearDeath(name,yearDeath))
        {
            view.print("Год смерти изменен на "+ yearDeath);
        }
        else view.print("Такой человек не найден");
    }
    public void save(String fileName) {
        if (service.save("family.txt")) {
            view.print("Семья сохранена успешно");
        } else view.print("Запись не удалась");
    }

    public void load(String fileName) {
        if (service.load("family.txt")) {
            view.print("Семья загружена успешно\n");
        } else view.print("Загрузка не удалась\n");
    }

    public void sortByName() {
        service.sortByName();
    }

}
