package Seminar6.src;
import Seminar6.src.notebooks.RandomNotes;
import Seminar6.src.presenter.Presenter;
import Seminar6.src.ui.*;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUi();
        Presenter presenter = new Presenter(view,new RandomNotes());
        view.launch();


    }
}
