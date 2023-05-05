package UI;

import Model.units.Unit;
import Presenter.Presenter;

import java.io.IOException;

public interface View{
    void setPresenter(Presenter presenter);

    void run() throws IOException;

    void addHuman();

    void getHumanList();

    void getAllInfo();

    void update() throws IOException;

    void finish();
}