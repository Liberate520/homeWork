package FamilyTree;

import FamilyTree.model.fileManagement.FileHandler;

import FamilyTree.model.servises.PersonService;
import FamilyTree.model.servises.Service;
import FamilyTree.presenter.Presenter;
import FamilyTree.view.Console;
import FamilyTree.view.View;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new Console();
        Service service = new PersonService();
        Presenter presenter = new Presenter(view, service);
        FileHandler fh = new FileHandler();
        String path = "homeWork/src/tree.save";
        view.load(fh, path);//автоматическая загрузка при запуске
        view.saveInit(fh, path);//передача параметров во вью, там сохранение запускается при выходе
        view.start();

    }
}