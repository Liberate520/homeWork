package HomeWork7.ui;

import HomeWork7.presenter.Presenter;

public interface View 
{
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    String scan(); 
}
