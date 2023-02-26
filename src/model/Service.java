package model;

public interface Service {
    public String showAll();
    public void load();
    public void save();

    public String showEntry(String name);
    public boolean addEntry(String name, String gender, String birthYear,
                         String fatherName, String motherName);

    boolean deleteEntry(String name);
}
