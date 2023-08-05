package ui;

class ConsoleMenu {
    private static ConsoleMenu consoleMenu;
    private static final StringBuilder menu = new StringBuilder();
    // Класс - конструктор меню
    private ConsoleMenu(){
        menu.append(String.format("%-40s %s \n", "Для выхода из программы нажмите: ", MenuPoint.EXIT));
        menu.append("Выберите пункт меню: \n");
        menu.append(String.format("%-40s %s \n", "Для добавления человека нажмите: ", MenuPoint.ADD_PERSON));
        menu.append(String.format("%-40s %s \n", "Для печати нажмите: ", MenuPoint.PRINT));
        menu.append(String.format("%-40s %s \n", "Для сохранения программы нажмите: ", MenuPoint.SAVE));
        menu.append(String.format("%-40s %s \n", "Для загрузки программы нажмите: ", MenuPoint.LOAD));
        menu.append(String.format("%-40s %s \n", "Для сортировки по полу нажмите: ", MenuPoint.SORT_BY_GENDER));
        menu.append(String.format("%-40s %s \n", "Для сортировки по возрасту нажмите: ", MenuPoint.SORT_BY_AGE));
        menu.append(String.format("%-40s %s \n", "Для сортировки по имени нажмите: ", MenuPoint.SORT_BY_NAME));
        menu.append(String.format("%-40s %s \n","Для добавления ребенка нажмите: ",MenuPoint.ADD_CHILDREN));
    }
    @Override
    public String toString() {
        return menu.toString();
    }

    public static ConsoleMenu getInstance(){
        if (consoleMenu==null){
            consoleMenu= new ConsoleMenu();
        }
        return consoleMenu;
    }
}
