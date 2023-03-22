package Notebook.Core.MVP;

import java.io.IOException;
import java.util.jar.JarException;

import Notebook.Core.MVP.Views.ViewRecord;
import Notebook.Core.Models.Recording;

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
        try {
            model.load();
        } catch (JarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}