package Notebook.Core.MVP;

import javax.swing.text.View;

public class Present {
    
    private Model model;
    private View view;

    public Present(View view, String pathDb03) {
        this.view = view;
        model = new Model(pathDb03);
    }

}
