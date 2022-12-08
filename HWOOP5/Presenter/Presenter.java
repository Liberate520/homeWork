package Presenter;
import Model.Calculate;
import View.View;

public class Presenter<T extends Calculate> {
    
    View view;
    T model;

    

    public T getModel() {
        return model;
    }

    public Presenter(View v, T m) {
        view = v;
        model = m;
    }

    public void start(){
        Double x = view.getValue("first operand: ");
        Double y = view.getValue("second operand: ");
        model.setX(x);
        model.setY(y);
        Double res = model.result(x, y);
        view.print(x, getModel().getOperand(), y, res);
        }
    }