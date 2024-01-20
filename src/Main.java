import ru.gb.view.ConsoleUI;
import ru.gb.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View app = new ConsoleUI();

        app.start();
        //TODO: при запросе в методе getByName этот ли член семьи нужен? запрашивать не "да/нет", а цифру
        //TODO: поработать над обработкой потенциальных ошибок
        //TODO: уьбрать возможность добавлять себя в качестве ребенка/родителя
        //TODO: допаботать пункт 8 - обработать момент когда не найден чел
        //TODO: при выборе 12 пункта, когда нет сохраненных древ, приложение падает с ошибкой
        //TODO: обработка чисел при дате рождения, введении номера древа,
        //TODO: при попытке сохранить дерево, если до этого уже есть сохраненное выходит ошибка java.io.NotSerializableException
    }
}
