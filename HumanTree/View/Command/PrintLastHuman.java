package View.Command;

import View.View;

public class PrintLastHuman implements Option{
    View view;

    public PrintLastHuman(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get last human in console";
    }

    @Override
    public void execute() {
        view.printLast();
    }
    
}
