package View.Command;

import View.View;

public class Command3 implements Option{
    View view;

    public Command3(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "3. Get last human in console";
    }

    @Override
    public void execute() {
        view.choose_3();
    }
    
}
