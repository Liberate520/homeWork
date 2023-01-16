import java.security.Provider.Service;

public class Presenter {
    private View view;
    public Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    

}
