package homeWork.HomeWork7.ui;

import homeWork.HomeWork7.presenter.Presenter;

public interface View 
{
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    String scan(); 
}