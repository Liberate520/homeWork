package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void loadFamilyTreeFromFile(String path) throws IOException, ClassNotFoundException {
        service.loadFamilyTreeFromFile(path);
    }

    public void getFamilyTreeInfo() {
        String treeInfo = service.getFamilyTreeInfo();
        view.printAnswer(treeInfo);
    }

    public void viewAllFamily(int id){
        String allFamilyInfo = service.viewAllFamily(id);
        view.printAnswer(allFamilyInfo);
    }

    public void sortById() {
        service.sortById();
        getFamilyTreeInfo();
    }
    public void sortByDateOfBirth() {
        service.sortByDateOfBirth();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }
}
