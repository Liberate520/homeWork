import model.humans.Gender;
import model.humans.tree.FamilyTree;
import model.Service;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        WorkingWithFiles workingWithFiles = new FileHandler();

        View view = new Console();
        Service service = new Service();
        new Presenter(view,service);

        view.start();


//        service.searchByID(2).getFullName();
//        service.searchByName("Ирина").setMother(service.searchByName("Павлина"));
//        service.searchByName("Павлина").setDateOfDeath("06.04.2008");

//        workingWithFiles.save(service.getFamilyTree());
//        FamilyTree tree = workingWithFiles.write();
//        service.printFamilySet(service.firstNameSort());
//        service.printFamilySet(service.birthdaySort());

    }
}
