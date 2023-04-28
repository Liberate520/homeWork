import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTreeModel model = new FamilyTreeModel();
        FamilyTreeView view = new FamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view);

        // Добавляем людей в модель
        presenter.addHuman(new Human("Сабина", 1965, "f"));
        presenter.addHuman(new Human("Сергей", 1959, "m"));
        presenter.addHuman(new Human("Диана", 1989, "f"));
        presenter.addHuman(new Human("Тимур", 1994, "m"));
        presenter.addHuman(new Human("Томирис", 1987, "f"));

        // Выводим информацию о человеке по имени
        Human timur = presenter.getHumanByName("Тимур");
        view.displayHuman(timur);

        // Выводим всех людей
        List<Human> allHumans = presenter.getAllHuman();
        view.displayAllHumans(allHumans);

        // Сохраняем в файл
        presenter.saveToFile("familyTree.dat");

        // Загружаем из файла
        presenter.loadFromFile("familyTree.dat");

        // Сортируем по имени
        presenter.sortByName();

        // Выводим отсортированный список
        allHumans = presenter.getAllHuman();
        view.displayAllHumans(allHumans);
    }
}
