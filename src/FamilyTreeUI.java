package DZ1;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class FamilyTreeUI implements View, Serializable {

    private Presenter presenter;
    private Scanner scanner;
    FileHandler fileHandler = new FileHandler();

    public FamilyTreeUI() {
        scanner = new Scanner(System.in, "Cp866");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {

        int flagOutofMainLoop = 0;

        while (flagOutofMainLoop == 0)

        {

            System.out.println(
                    "\n1 - Вывести всех людей из дерева\n2 - Поиск по имени\n3 - Очистить дерево \n4 - Выгрузить в файл \n5 - Загрузить из файла\n6 - Сортировка дерева  \n7 - Выход\nВведите цифру, соответствующую необходимому критерию:");

            int userChoiceStartMenu = scanner.nextInt();

            switch (userChoiceStartMenu) {
                case 1:
                    scanner.nextLine();
                    System.out.println(presenter.getAllHumans());
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Введите имя: ");
                    String userInputName = scanner.nextLine();
                    System.out.println(presenter.getHumanByNameAndRelatives(userInputName));
                    break;
                case 3:
                    presenter.clearTree();
                    break;
                case 4:
                    Human humantemp = new Human();
                    humantemp.setWritable(fileHandler);
                    humantemp.save(presenter.getHumans());
                    break;
                case 5:
                    Human newHuman1 = new Human();
                    newHuman1.setWritable(fileHandler);
                    presenter.addList(newHuman1.read());
                    break;
                case 6:

                    System.out.println(
                            "\n1 - Сортировка по имени\n2 - сортировка по полу\nУкажите параметр сортировки: ");
                    int userChoiceSortMenu = scanner.nextInt();
                    switch (userChoiceSortMenu) {
                        case 1:
                            presenter.sortByName();
                            System.out.println("Отсортировано по имени");
                            break;
                        case 2:
                            presenter.sortByGender();
                            System.out.println("Отсортировано по полу");
                            break;
                    }
                    break;
                case 7:
                    flagOutofMainLoop = 1;
                    break;
                default:
                    System.out.println("Некорректный ввод ");
                    break;
            }
        }
        scanner.close();
    }
}
