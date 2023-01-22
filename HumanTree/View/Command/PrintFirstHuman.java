package View.Command;

import View.View;

public class PrintFirstHuman implements Option{
    View view;

    public PrintFirstHuman(View view) {
        this.view = view;
    }


    @Override
    public String discription() {        
        return "Get first human in console";
    }

    @Override
    public void execute() {
        view.printFirst();  
    }
    
}
