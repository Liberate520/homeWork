public class Pressenter {

    View view;
    Model model;

    public Pressenter(Model m, View v) {
        model = m;
        view = v;
    }

    public void buttonClick() {

        double a = view.getValue("Введите число a: ");
        double b = view.getValue("Введите число b: ");
        int ch = view.getChoice("\n" +
                "1. -> Сложение а и b\n" +
                "2. -> Вычитание а и b\n" +
                "3. -> Умножение а и b\n" +
                "4. -> Деление а и b\n" +
                "5. -> Возведение а в степень b\n" +
                "6. -> Остаток от деления а и b\n" +
                "Выберете действие: ");

        model.setX(a);
        model.setY(b);
        double res = model.calc(ch);
        view.print(res, "Результат: ");
    }
}
