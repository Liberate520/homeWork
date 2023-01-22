package View.Command;

import View.View;

public class PrintFirstHumanChild implements Option{
    View view;

    public PrintFirstHumanChild(View view) {
        this.view = view;
    }
    
    @Override
    public String discription() {        
        return "Get child first human in console";
    }

    @Override
    public void execute() {
        view.printFirstChild();  
        
    }
    
}
