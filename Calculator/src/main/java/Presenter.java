public class Presenter {
    View view;
    Model model;

    public Presenter(Model m, View v) {
        model = m;
        view = v;
    }

    public void startAction() {
        Float a = view.getValue("Введите первое число: ");
        Float b = view.getValue("Введите второе число: ");
        model.setX(a);
        model.setY(b);
        Float result = (Float) model.result();
        view.print(result, "Результат: ");
    }
}