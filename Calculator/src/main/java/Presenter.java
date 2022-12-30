public class Presenter {
    View view;
    Model model;

    public Presenter(Model m, View v) {
        model = m;
        view = v;
    }

    public void startAction() {
        double a = view.getValue("Введите первое число: ");
        double b = view.getValue("Введите второе число: ");
        model.setX(a);
        model.setY(b);
        view.print((float) model.result(), "Результат: ");
    }
}