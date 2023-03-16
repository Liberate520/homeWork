package presenter;

import ui.View;

import java.io.IOException;
import java.util.Map;

import familyTreeModel.Service;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void ShowList() throws ClassNotFoundException, IOException {
        String answer = service.ShowList();
        view.print(answer);
    }

    public void Search(Map<String, String> data) throws ClassNotFoundException, IOException {
        String answer = service.Search(data);
        view.print(answer);
    }

    public void getChildren(Map<String, String> data) {
        String answer = service.getChildren(data);
        view.print(answer);
    }

    public void Add(Map<String, String> data) throws ClassNotFoundException, IOException {

        String answer = service.Add(data);
        view.print(answer);
    }
}