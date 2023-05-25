package ui;

import presenter.Presenter;

public interface View {

    void setPresenter(Presenter presenter);

    void print(String text);

    void start();

    void addHuman();

    void removeHuman();

    void exit();

    void save();

    void load();

    void setMale();

    void setFemale();

    void showFullInfo();

    void showShortInfo();

    void showGenderStatistics();

    void showGrandFatherInfo();

    void showGrandMotherInfo();

}
