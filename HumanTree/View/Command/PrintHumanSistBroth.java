package View.Command;

import View.View;

public class PrintHumanSistBroth implements Option{
    View view;

    public PrintHumanSistBroth(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get human sisters and brothers in console";
    }

    @Override
    public void execute(int order) {
        view.printHumanSistBroth(order);        
    }
        
    @Override
    public void execute() {         
        System.out.println("Lost id of human");
        return;
    }
}
