package View.Command;

import View.View;

public class Command1 implements Option{    
    View view;

    public Command1(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "1. Get all human in console.";
    }

    @Override
    public void execute() {        
        view.choose_1();
    }
    
}
