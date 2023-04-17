package presenter;

import java.util.List;

import model.tree.classes.Human;
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

    public List getTree(){
        return service.getTree();
    }

    public void setHuman(Human person){
        service.setHuman(person);
    }

    public void addPerson(Human person){
        service.addPerson(person);
    }

    public List searchPerson(String str){
        return service.serachPerson(str);
    }

    public void printTree(){
        String tree = service.treeToString();
        view.print(tree);
    }

    public void saveTree(){
        service.saveTree();
    }

    public void loadTree(){
        service.loadTree();
    }
}
