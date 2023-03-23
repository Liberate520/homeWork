package presenter;

import model.Service;
import ui.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service = new Service();
    public Presenter(View view){
        this.view=view;
        view.setPresenter(this);
    }
    public String myNotes(){
        return service.myNotes();
    }
    public String loadData() throws IOException, ClassNotFoundException {
        return service.loadData();
    }
    public String saveData() throws Exception {
        return service.saveData();
    }
    public String addNotes(String notes){
        return service.addNotes(notes);
    }
    public String printNotes(){
        return service.printNotes();
    }
    public String deleteNotes(int number){
        return service.deleteNotes(number);
    }



}
