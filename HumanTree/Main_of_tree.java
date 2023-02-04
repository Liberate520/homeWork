import java.io.Serializable;

import Controller.Controller;
import Model.HumanTreeOperation;
import View.View;

public class Main_of_tree implements Serializable{
    public static void main(String[] args){
        View view = new View();
        HumanTreeOperation humanTreeOperation = new HumanTreeOperation();
        Controller controller = new Controller(view, humanTreeOperation);        
        view.setController(controller);
        view.start();
    }
}
