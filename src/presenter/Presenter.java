package presenter;

import ui.View;
import geotree.Research;

public class Presenter {
    private View view;
    private Research research;

    public Presenter(View view, Research research) {
        this.view = view;
        this.research = research;
        view.setPresenter(this);
    }

    public void onClick(String person){
        String answer = research.findPersonByName(person);
        view.print(answer);
    }
}
