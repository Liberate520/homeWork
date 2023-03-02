package model;

import java.time.LocalDate;

import presenter.Presenter;

public interface Model {
    public void setPresenter(Presenter presenter);

    public void demoTree();

    public void addTreeEntity(String name, String lastname, String sexStr, LocalDate dateOfBirth);

    public String showEntityInfo(int num);

    public String printTree();

}
