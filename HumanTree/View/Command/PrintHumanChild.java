package View.Command;

import View.View;

public class PrintHumanChild implements Option{
    View view;

    public PrintHumanChild(View view) {
        this.view = view;
    }
    
    @Override
    public String discription() {        
        return "Get child human in console";
    }

    @Override
    public void execute(int order) {
        view.printHumanChild(order); 
    }    
    
    @Override
    public void execute() {         
        System.out.println("Lost id of human");
        return;
    }
}
