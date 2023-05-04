package ui;

import presenter.Presenter;

public interface View {
    
    void setPresenter(Presenter presenter);
    void print(String text);
    void start();
    
}
