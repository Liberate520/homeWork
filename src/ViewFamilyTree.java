import java.util.Scanner;

public class ViewFamilyTree<T extends People> {
    Family<T> familytree;
    T people;

    public ViewFamilyTree(Family<T> familytree) {
        this.familytree = familytree;
    }

    public void viewTree() {
        while (true) {
            int value =0;
            String text = null;
            try (Scanner iScanner = new Scanner(System.in, "Cp866")) {
                System.out.println(
                        "\n1 - Показать все объекты дерева\n2 - Отсортировать по имени\n3 - Отсортировать по дате\n4 - Поиск члена семьи по имени\n5 - Поиск члена семьи по имени и его связи\n0 - Выйти");
                try {
                    value = iScanner.nextInt();
                } catch (Exception e) {
                    // 
                    errorMessage(e);
                }

                switch (value) {
                    case 1:
                        familytree.showTree();
                        break;

                    case 2:
                        familytree.sortByName();
                        familytree.showTree();
                        break;

                    case 3:
                        familytree.sortByDate();
                        familytree.showTree();
                        break;

                    case 4:
                        try {
                            System.out.println("Введите имя для поиска:");
                            iScanner.nextLine();
                            text = iScanner.nextLine();
                            System.out.println(familytree.search(text));
                        } catch (Exception e) {
                            errorMessage(e);
                        }

                        break;

                    case 5:
                        try {
                            System.out.println("Введите имя для поиска:");
                            iScanner.nextLine();
                            text = iScanner.nextLine();
                            System.out.println(familytree.getFamMembers(text));
                        } catch (Exception e) {
                            errorMessage(e);
                        }

                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Ошибка ввода. Повторите еще раз.\n");
                        break;
                }
            }
        }
    }

    private void errorMessage(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        System.out.println("Данные неверны, попробуйте еще раз\n");
    }
}
