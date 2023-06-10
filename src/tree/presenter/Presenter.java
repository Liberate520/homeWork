package tree.presenter;

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
        System.out.println(service.findHuman(name).toString());
    }

    public void saveFile() throws IOException {
        service.saveObject();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        service.loadFile();
    }

    public void addChild(String human, String child) {
        service.addChild(human, child);
        System.out.println(String.format("%s добавлен ребенок %s", human, child));
    }
}
