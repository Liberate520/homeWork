package oop.familyTree;

import oop.familyTree.mvp.model.Service;

public class MainTest {
    public static void main(String[] args) {
        Service service = new Service();
        service.changeField("Ивановы", "Иванов Иван", 1,"Смирнов Иван");
    }
}
