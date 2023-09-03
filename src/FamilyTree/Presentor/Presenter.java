package family_tree.FamilyTree.Presentor;

import family_tree.FamilyTree.Model.Person.Gender;
import family_tree.FamilyTree.Model.Servce.Service;
import family_tree.FamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPerson(String fName, String lName, Gender gen, LocalDate dataB) {
        service.addPerson(fName, lName, gen, dataB);
        getTree();
    }

    public void getTree() {
        String response = service.getListInfo();
        view.printResponse(response);
    }

    public void addParent(int intChilgren, int intParent) {
        service.setParentForINN(intChilgren, intParent);
        getTree();
    }

    public void sortByName() {
        service.sortByName();
        getTree();
    }

    public void sortByAge() {
        service.sortByAge();
        getTree();
    }

    //TODO добавить вывод сообщение что выгрузка прошла успешна. куда??? ПЕРЕИМЕНОВАТЬ
    public void importToFile(String namefile) throws IOException {
        service.extractFromFile(namefile); //доста из файла
        getTree();
    }

    //TODO добавить вывод сообщение что загрузка прошла успешна. куда??? ПЕРЕИМЕНОВАТЬ
    public void exportFromFile(String namefile) throws IOException {
        service.archiveToFile(namefile); // заархивировать

    }

    public void marriage(int innFPartner, int innSPartner) {
        service.marriageForINN(innFPartner, innFPartner);
        getTree();
    }

    public void divorce(int innFPartner, int innSPartner) {
        service.divorceForINN(innFPartner, innSPartner);
        getTree();
    }
}
