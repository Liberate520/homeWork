package Controller;

import Model.Model;
import View.View;

public class Controller {
    private View view;
    private Model model;
    

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);        
    }

      
    public void onClick(String action){
        if (action.equals("all human")){            
            model.print();
        }
        else if (action.equals("first human")){
            model.printFirst();
        }
        else if (action.equals("last human")){
            model.printLast();
        }        
    }
}
