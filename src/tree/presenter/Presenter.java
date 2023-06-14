package tree.presenter;

import tree.model.human.Human;
import tree.model.Service;
import tree.model.human.Gender;

import java.io.IOException;

public class Presenter {
    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public void addHuman(String name, Gender gender, String father, String mother) {
        service.addHuman(name, gender, father, mother);

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
        service.findHuman(name);
    }

    public void saveFile() throws IOException {
        service.saveObject();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        service.loadFile();
    }

   /* public void addChild(String human, String child) {
        Human parent = service.findHuman(human);
        Human kid = service.findHuman(child);
            if (containsHuman(parent) && containsHuman(kid)) {
                service.addChild(parent, kid);
                System.out.printf("%s добавлен ребенок %s\n", human, child);
            } else {
            System.out.println("Ошибка");
        }
    }
    private boolean containsHuman(Human human) {
        return human != null;
    }*/
}
