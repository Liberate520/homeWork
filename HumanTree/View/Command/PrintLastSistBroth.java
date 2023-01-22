package View.Command;

import View.View;

public class PrintLastSistBroth implements Option{
    View view;

    public PrintLastSistBroth(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Get last human sisters and brothers in console";
    }

    @Override
    public void execute() {
        view.printLastSistBroth();
        
    }
    
}
