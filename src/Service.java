public interface Service {

    public String showAll();

    public void load();

    public void save();

    public String showEntry(String lastname, String firstname);

    public boolean addEntry(String lastname, String firstname, String gender, String patronymic, String fatherName, String motherName);
}