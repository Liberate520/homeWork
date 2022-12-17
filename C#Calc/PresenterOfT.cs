public class PresenterOfT<T>:CalcModel {
    View view;
    Model model;

    public PresenterOfT(T m, View v) {
        model = m;
        view = v;
    }

    public void buttonClick(){
        double a = view.getValue("a: ");
        double b = view.getValue("b: ");
        string action = view.getAction("action: ");
        model.setX(a);
        model.setY(b);
        model.setAction(action);
        if (action == "+"){
            double result = model.resultSum();
            view.print(result, "Sum: ");

        }

        if(action == "-") {
            double result = model.resultSub();
            view.print(result, "Sub: ");
        }

        if(action == "*"){
            double result = model.resultMult();
            view.print(result, "Mult: ");
        }

        if(action == "/"){
            double result = model.resultDiv();
            view.print(result, "Div: ");
        }
    }
}
