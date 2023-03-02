package HomeWork5.ui;

import HomeWork5.presenter.Presenter;

public interface View 
{
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    String scan(); 
}
