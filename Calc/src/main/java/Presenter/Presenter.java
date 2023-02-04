package Presenter;
import Model.Model;
import UI.View;


public class Presenter {
    View view;
    Model model;

    public Presenter(Model m, View v) {
        model = m;
        view = v;
    }

    public void buttonClick(){
        double a = view.getValue("a: ");
        double b = view.getValue("b: ");
        String action = view.getAction("action: ");
        model.setX(a);
        model.setY(b);
        model.setAction(action);
        if (action.equals("+")){
            double result = model.resultSum();
            view.print(result, "Sum: ");
        }

        if(action.equals("-")) {
            double result = model.resultSub();
            view.print(result, "Sub: ");
        }

        if(action.equals("*")){
            double result = model.resultMult();
            view.print(result, "Mult: ");
        }

        if(action.equals("/"))

        {
            double result = model.resultDiv();
            view.print(result, "Div: ");
        }



    }



}
