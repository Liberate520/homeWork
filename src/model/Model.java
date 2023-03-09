package model;

import java.time.LocalDate;

public interface Model {

    public void demoTree();

    public void addTreeEntity(String name, String lastname, String sexStr, LocalDate dateOfBirth);

    public String showEntityInfo(int num);

    public String printTree();

    public void newTree();

}
