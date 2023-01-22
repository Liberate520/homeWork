package View.Command;

import View.View;

public class PrintLastFather implements Option{
    View view;

    public PrintLastFather(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get last human father in console";
    }

    @Override
    public void execute() {
        view.printLastFather();
        
    }
    
}
