package presenter;

import java.util.ArrayList;

import genealogicalTree.GenealogicalTree;
import genealogicalTree.Model;
import ui.View;

public class Presenter {

    private View view;
    private Model model;

    public Presenter(View view, Model model){
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void addMember(ArrayList<String> member) {
        model.addMember(member);
    }

    public void printMember(String name) {
        model.printmember(name);
    }

    public void printTree() {
        model.printTree();
    }

    public void addParents(ArrayList<String> member) {
        model.addParents(member);
    }
    
}
