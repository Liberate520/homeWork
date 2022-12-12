package Model;

import UI.View;


public class ActionModel extends CalcModel{
    public ActionModel() {

    }
    // do_it
    @Override
    public  double resultSum() {
        return x + y;
    }

    @Override
    public double resultSub() {
        return x - y;
    }

    @Override
    public double resultMult() {
        return x * y;
    }

    @Override
    public double resultDiv() {
        return x/y;
    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        super.y = value;
    }

    @Override
    public void setAction(String value) {
        super.action = value;
    }




}
