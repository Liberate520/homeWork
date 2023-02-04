package View.Command;

import View.View;

public class PrintHuman implements Option{
    View view;

    public PrintHuman(View view) {
        this.view = view;
    }


    @Override
    public String discription() {        
        return "Get human in console";
    }

    @Override
    public void execute(int order) {
        view.printHuman(order);  
    }


    @Override
    public void execute() {
        System.out.println("Lost id of human");
        return;        
    }
    
}
