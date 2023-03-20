package main;

public interface Service {

    public String printTree();

    public void load();

    public void save();

    public String findHuman(String lastname, String firstname);

    public boolean addNewHuman(String lastname, String firstname, String gender, String patronymic, String fatherName, String motherName);
}