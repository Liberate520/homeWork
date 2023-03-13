package ui;
import java.io.FileNotFoundException;
import java.io.IOException;

import presenter1.Presenter;


public interface View {
    void setPresenter(Presenter presenter);
    void start() throws NumberFormatException, FileNotFoundException, IOException;
    void print(String text);
}
