package HomeWork5.ui;

import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;
import HomeWork5.presenter.Presenter;

public interface View 
{
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    void print(Human human);
    void print(FamilyFree<Human> FamilyFree);
    String scan(); 
}