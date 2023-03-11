package presenter;

import ui.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import familyTreeModel.Service;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onClick(HashMap<String, String> request) throws FileNotFoundException, ClassNotFoundException, IOException{
        String answer = service.get(request);
        view.print(answer);
    }
}