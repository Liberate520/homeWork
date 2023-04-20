package presenter;


import service.Service;
import view.View;

import java.io.IOException;


public class Presenter<T> {
    private View view;
    private Service service;
    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void presenterPrintTree()
    {
        service.AddPeson();
    }
    public void presenterFindHuman()
    {
        service.FindHuman();
    }
    public void presenterSortByName()
    {
        service.SortByName();
    }
    public void presenterSortByDate()
    {
        service.SortByDate();
    }
    public void presenterSaveData() throws IOException, ClassNotFoundException {
        service.DataSaveFile();
    }
    public void presenterLoadData() throws IOException, ClassNotFoundException {
        service.DataLoadFile();
    }
}
