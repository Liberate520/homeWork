package GenerationTree.Presenter;

import java.nio.file.FileAlreadyExistsException;
import java.util.LinkedList;
import java.util.List;

import GenerationTree.Model.Person.FamilyTreeService;
import GenerationTree.Model.Tree.Service;
import GenerationTree.View.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new FamilyTreeService();
    }

    public void addNewTree(String name) {
        try {
            service.addNewTree(name);
        } catch (FileAlreadyExistsException e) {
            view.fileExist();
        }
    }

    public List<String> getAllTrees() {
        var forest = service.getForest();
        if (forest == null) {
            forest = new LinkedList<>();
        }
        return forest;
    }

    public void loadTree(String name) {
        service.loadTree(name);
    }

    public boolean deleteTree(String name) {
        return service.deleteTree(name);
    }
}