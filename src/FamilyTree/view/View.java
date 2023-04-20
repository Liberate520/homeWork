package FamilyTree.view;

import FamilyTree.presenter.Presenter;
import FamilyTree.model.fileManagement.SaveLoad;

public interface View {

    void print(String text);
    void start();
    void askAndAnswer(String question);
    void setPresenter(Presenter presenter);
    // void save(SaveLoad sl, String path);
    void load(SaveLoad sl, String path);
    void saveInit(SaveLoad sl, String path);//передает во вью нужные параметры, чтобы во вью можно было запустить метод save
    // void viewAll();//потом убрать отсюда, сделать приватными в консоле и вызывать через паблик старт
    // void addRecord();//потом убрать отсюда, сделать приватными в консоле и вызывать через паблик старт
}