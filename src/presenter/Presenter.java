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

    public void onClickFind(String person){
        String answer = research.findPersonByName(person);
        view.print(answer);
    }
    public void onClickAddHuman(String dataForPerson){
        String answer = research.AddHuman(dataForPerson);
        view.print(answer);
    }
    public void onClickGetHuman(String person){
        String answer = research.GetHuman(person);
        view.print(answer);
    }
    public void onClickGetAll(){
        String answer = research.GetAll();
        view.print(answer);
    }
}
