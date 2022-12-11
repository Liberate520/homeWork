package app;

import presenter.Presenter;
import service.Service;
import service.classes.Person;
import service.dataBase.DataBase;
import view.Dispatcher;

public class Main {
    public static void main(String[] args) {
        DataBase db = DataBase.getDB();
        Dispatcher dp = new Dispatcher();
        Presenter presenter = new Presenter(dp);
        dp.setPresenter(presenter);
        Service service = new Service(presenter, db);
        presenter.setService(service);
        dp.start();
    }
}