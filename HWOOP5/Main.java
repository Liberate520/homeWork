import Model.DivisionModel;
import Model.MultiplicationModel;
import Model.SubtractionModel;
import Model.SumModel;
import Presenter.Presenter;
import View.View;

public class Main {
    public static void main(String[] args) {
        Presenter<SumModel> presenter = new Presenter<SumModel>(new View(), new SumModel());
        System.out.println("Summation");
        presenter.start();
        Presenter<DivisionModel> presenter1 = new Presenter<DivisionModel>(new View(), new DivisionModel());
        System.out.println("Division");
        presenter1.start();
        Presenter<MultiplicationModel> presenter2 = new Presenter<MultiplicationModel>(new View(), new MultiplicationModel());
        System.out.println("Multiplication");
        presenter2.start();
        Presenter<SubtractionModel> presenter3 = new Presenter<SubtractionModel>(new View(), new SubtractionModel());
        System.out.println("Subtraction");
        presenter3.start();
    }
}