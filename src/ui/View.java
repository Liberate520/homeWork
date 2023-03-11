package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start() throws FileNotFoundException, ClassNotFoundException, IOException;
    HashMap<String, String> menu();
    void print(String data);
    
}
