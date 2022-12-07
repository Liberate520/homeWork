import Model.ActionModel;
import Presenter.Presenter;
import UI.View;

public class Program {
    public static void main(String[] args) {
        Presenter p = new Presenter(new ActionModel(), new View());
        p.buttonClick();


    }
}
