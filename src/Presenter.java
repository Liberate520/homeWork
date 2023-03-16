public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addEntry(String lastname, String firstname, String patronymic, String gender, String fatherName, String motherName) {
        return service.addEntry(lastname, firstname, patronymic, gender, fatherName, motherName);
    }

    public void showEntry(String lastname, String firstname) {
        view.print(service.showEntry(lastname, firstname));
    }

    public void showAllEntries() {
        view.print(service.showAll());
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }
}