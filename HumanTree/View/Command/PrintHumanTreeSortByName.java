package View.Command;

import View.View;

public class PrintHumanTreeSortByName  implements Option{    
    View view;

    public PrintHumanTreeSortByName(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get all human in console sort by name.";
    }

    @Override
    public void execute() {        
        view.sortHumanByName();
    }    
        
    @Override
    public void execute(int order) {         
        System.out.println("Unnecessary id of human");
        return;
    }    
}
