package View.Command;

import View.View;

public class PrintHumanTreeSortByBirth implements Option{    
    View view;

    public PrintHumanTreeSortByBirth(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get all human in console sort by birth.";
    }

    @Override
    public void execute() {        
        view.sortHumanByBirth();
    }    
        
    @Override
    public void execute(int order) {         
        System.out.println("Unnecessary id of human");
        return;
    }    
}
