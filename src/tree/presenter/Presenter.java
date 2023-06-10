package tree.presenter;

import tree.human.Human;
import tree.model.Service;
import tree.human.Gender;

import java.io.IOException;

public class Presenter {
    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public void addHuman(String name, Gender gender) {
        service.addHuman(name, gender );
        System.out.println(name + " добавлен");
    }
    public void getFamilyTree() {
        System.out.println(service.toString());
    }
    public void sortByName() {
        service.sortByName();
        System.out.println("Файл отсортирован по имени");
    }
    public void sortByChild() {
        service.sortByChild();
        System.out.println("Файл отсортирован по количеству детей");
    }
    public void findHuman(String name) {
        try {
            System.out.println(service.findHuman(name).toString());
        } catch (Exception e) {
            System.out.println("Не найден");
        }
    }

    public void saveFile() throws IOException {
        service.saveObject();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        service.loadFile();
    }

    public void addChild(String human, String child) {
            if (containsHuman(service.findHuman(child)) && containsHuman(service.findHuman(human))) {
                service.findHuman(human).addChild(service.findHuman(child));
                System.out.println(String.format("%s добавлен ребенок %s", human, child));
            } else {
            System.out.println("Ошибка");
        }
    }
    private boolean containsHuman(Human human) {
        if (human != null) return true;
        return false;
    }
}
