package Notebook.Core.MVP;
import Notebook.Core.Essence.Recording;
import Notebook.Core.MVP.Models.Model;
import Notebook.Core.MVP.Views.ViewRecord;

public class Presenter {

    private Model model;
    private ViewRecord view;
    

    public Presenter(ViewRecord view, String path) {
        this.view = view;
        model = new Model(path);
    }

    public void append() {
        model.append(view.getTitle(), view.getRecording());
    }

    public void show (){
        model.showAll();
    }

    public void loadFromFile() {
        model.load();
    }

    public void remove(int index){
        model.remove(index);
    }

    public void set(int index) {
        model.set(index, new Recording(view.getTitle(), view.getRecording()));
    }

    public void save (){
        try {
            model.save();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}