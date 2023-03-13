package model;

public interface Service {
    public String outputAList();
    public String searchByName(String nextLine);
    public void load();
    public void save();
    public void sortAlfab();
    public void sortYear();
    public boolean addHuman(String fullName, String dateBirth, String mother, String father);
    public boolean deletePerson(String nextLine);
}
