package Project_MyFamilyTree_MVP;

public class Presenter {
    private View view;
    private Service service;
    
    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);    // Presenter передает ссылку View на себя, чтобы последний понимал, куда в дальнейшем обращаться.
    }

    public void getHumanListInPresenter() {
        String request = service.getHumanList();
        view.print(request);
    }

    public void addHumanInPresenter(String name, LocalDate birthday, Gender gender) {
        service.addHumanInService(name, gender, birthday);
    }
}