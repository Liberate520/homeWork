package View.Command;

import View.View;

public class PrintHumanMother implements Option{
    View view;

    public PrintHumanMother(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get human mother in console";
    }

    @Override
    public void execute(int order) {
        view.printHumanMother(order);        
    }
    
        
    @Override
    public void execute() {         
        System.out.println("Lost id of human");
        return;
    }
}
