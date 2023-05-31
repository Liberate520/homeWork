package java_oop_homeWork.src;

import java_oop_homeWork.src.model.Service;
import java_oop_homeWork.src.presenter.Presenter;
import java_oop_homeWork.src.ui.Console;
import java_oop_homeWork.src.ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new Console();
        Service service = new Service();
        service.read("FamilyTrees");
        Presenter presenter = new Presenter(view, service);
        view.start();
        service.write("FamilyTrees");
    }
}