package View.Command;

import View.View;

public class PrintHumanTreeFile implements Option{
    View view;

    public PrintHumanTreeFile(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get all human in file.";
    }

    @Override
    public void execute() {        
        view.printFile();
    }
}
