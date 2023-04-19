package presenter;

import java.util.List;
import model.tree.classes.Service;
import view.iView;

public class Presenter {
    private iView view;
    private Service service;

    public Presenter(iView view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public List getTree() {
        return service.getTree();
    }

    public void setHuman() {
        service.setHuman();
    }

    public void searchPerson() {
        service.serachPerson();
    }

    public void printTree() {
        String tree = service.treeToString();
        view.print(tree);
    }

    public void saveTree() {
        service.save("src/model/storages/Test.out");
    }

    public void loadTree() {
        service.load("src/model/storages/Test.out");
    }
}
