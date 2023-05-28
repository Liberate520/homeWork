package presenter;
import java.io.Serializable;
import model.human.Gender;
import ui.Service;
import ui.View;

public class Presenter implements Serializable {
    private View view;
    private Service service;    

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;        
        view.setPresenter(this);
    }

    public void addHuman(int id, String name, String surname, String dateOfBirth, Gender gender) {
        service.addHuman(id++, name, surname, dateOfBirth, null);
    }
    
    public void getInfo() {
        view.print(service.getInfo());
    }
    
    public void saveFile() {
        service.save();
    }
    
    public void readFile() {
        service.read();
    }

}
