package View.Command;

import View.View;

public class Command2 implements Option{
    View view;

    public Command2(View view) {
        this.view = view;
    }


    @Override
    public String discription() {        
        return "2. Get first human in console";
    }

    @Override
    public void execute() {
        view.choose_2();  
    }
    
}
