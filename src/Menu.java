public class Menu {
    public static void greetings() {
        System.out.println("Добро пожаловать в генеалогическое древо.\n");
    }

    public static void mainMenu() {
        System.out.print("1. Показать древо\n" +
                        "2. Добавить человека\n" + 
                        "3. Поиск человека по имени\n" + 
                        "4. Загрузить древо\n" + 
                        "5. Сохранить древо\n" + 
                        "6. Отсортировать дерево.\n" +
                        "7. Завершить.\n" +
                        "Выберите действие : ");
    }

    public static void secondMenu() {
        System.out.print("\n1. Показать детей\n" +
                        "2. Показать мать\n" +
                        "3. Показать отца\n" +
                        "4. В основное меню\n" +
                        "Выберите действие : ");
    }

    public static void fileHandler() {
        System.out.print("1. Txt\n" +
                        "2. Csv (в разработке)\n" +
                        "3. Json (в разработке)\n" +
                        "Выберите формат файла: ");
    }
    
    public static void sortMenu() {
        System.out.print("\n1. Имя\n" +
                        "2. Год рождения\n" +
                        "Выберите по какому критерию сортировать: ");
    }
}
