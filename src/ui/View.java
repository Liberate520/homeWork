package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void start() throws FileNotFoundException, ClassNotFoundException, IOException;

    void print(String data);

    Map<String, String> getData();

    String getName(String status);

    String getSurname(String status);

    void сompleteDatEntry();

    Presenter getPresenter();
}
