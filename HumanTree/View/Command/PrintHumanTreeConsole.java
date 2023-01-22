package View.Command;

import View.View;

public class PrintHumanTreeConsole implements Option{    
    View view;

    public PrintHumanTreeConsole(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get all human in console.";
    }

    @Override
    public void execute() {        
        view.printConsole();
    }
    
}
