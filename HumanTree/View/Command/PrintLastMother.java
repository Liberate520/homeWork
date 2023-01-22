package View.Command;

import View.View;

public class PrintLastMother implements Option{
    View view;

    public PrintLastMother(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get last human mother in console";
    }

    @Override
    public void execute() {
        view.printLastMother();        
    }
    
}
