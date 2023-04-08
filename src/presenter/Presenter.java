package presenter;

import person.Gender;
import person.Person;
import ui.View;
import geotree.Research;

import java.util.GregorianCalendar;

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
        String answer;
        try{
            answer = research.AddHuman(new Person(dataForPerson.split(",")[0], new GregorianCalendar(Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[0]),
                    Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[1]), Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[2])), Gender.Male));
        }catch (Exception e){
            answer = "Can't create human!";
        }
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
