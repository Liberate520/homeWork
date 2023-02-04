package View.Command;

import View.View;

public class PrintHumanFather implements Option{
    View view;

    public PrintHumanFather(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get human father in console";
    }

    @Override
    public void execute(int order) {
        view.printHumanFather(order);        
    }
        
    @Override
    public void execute() {         
        System.out.println("Lost id of human");
        return;
    }
    
}
