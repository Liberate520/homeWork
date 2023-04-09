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

    public void find(String person){
        String answer = research.findPersonByName(person);
        view.print(answer);
    }
    public void addHuman(String dataForPerson){
        String answer = research.addHuman(dataForPerson);
        view.print(answer);
    }
    public void getHuman(String person){
        String answer = research.getHuman(person);
        view.print(answer);
    }
    public void getByAge(String age){
        String answer = research.searchAge(age);
        view.print(answer);
    }
    public void getAll(){
        String answer = research.getAll();
        view.print(answer);
    }
}
