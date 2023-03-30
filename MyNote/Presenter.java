package MyNote;
import MyNote.Model.Model;
import MyNote.UI.View;



public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

 

    public void addRecord(String volue){
        model.addRecord(volue);
        view.showRecordAdded();
       
    }

    public Notebook getAll(){
        return model.getRecords();
    }
    
    public void removeRecord() {
        int index=view.getIndex();
        model.removeRecord(index);   
    }
 
   
    

}
