package GenerationTree.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import GenerationTree.Presenter.Presenter;
import GenerationTree.View.MenuRender.ConsoleManager;
import GenerationTree.View.MenuRender.MenuRender;

public class ConsoleUI implements View {

    private final int CONSOLE_LINES = 12;

    private Presenter presenter;
    private ConsoleManager cmdManager;

    public ConsoleUI() {
        cmdManager = new ConsoleManager();
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        var appIsRun = true;
        while (appIsRun) {
            clsField();
            appIsRun = startupMenu();
        }
        appClose();
    }

    @Override
    public void fileExist() {
        throw new UnsupportedOperationException("Unimplemented method 'fileExist'");
    }

    @Override
    public void print(String text) {
        cmdManager.PrintText(text);
        cmdManager.inputText("      Для проболжения нажмите Enter...");
    }

    private void clsField() {
        String header = "ПРОГРАММА: Генеалогическое древо семьи. Версия 0.000.00 pre-Alpha"
                + " ".repeat(32);
        cmdManager.consoleClear();
        cmdManager.PrintText(header);
        cmdManager.PrintText("=".repeat(header.length()));
    }

    private boolean startupMenu() {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put("ВЫБЕРИТЕ ДЕЙСТВИЕ",
                Arrays.asList("СОЗДАТЬ ДРЕВО", "ВЫБРАТЬ ДРЕВО", "УДАЛИТЬ ДРЕВО"));
        menuData.put("-----", Arrays.asList("ВЫХОД"));
        int commandKey = 1;
        var isActiveMenu = true;
        while (isActiveMenu) {
            clsField();
            commandKey = StartMenu(menuData, commandKey);
            switch (commandKey) {
                case 1:
                    newTree();
                    break;
                case 2:
                    menuLoadTree();
                    break;
                case 3:
                    menuDeleteTree();
                    break;
                default:
                    if (yesNoDialog("Закрыть приложение?"))
                        return false;
                    else if (commandKey == 0)
                        commandKey++;
                    break;
            }
        }
        return true;
    }

    private void newTree() {
        var enteringProcess = true;
        while (enteringProcess) {
            clsField();
            String surname = cmdManager.inputText("Введите фамилию семьи: ");
            if (surname.isEmpty()) {
                continue;
            }
            this.presenter.addNewTree(surname);
            enteringProcess = false;
        }
    }

    private void menuLoadTree() {
        List<String> allTrees = presenter.getAllTrees();
        if (allTrees.size() == 0) {
            if (yesNoDialog("Отсутствуют файлы сохранения. Создать новое древо?")) {
                newTree();
            }
            return;
        }
        var name = menuSavedTree(allTrees);
        if (!name.isEmpty())
            this.presenter.loadTree(name);
    }

    private void menuDeleteTree() {
        List<String> allTrees = presenter.getAllTrees();
        if (allTrees.size() == 0) {
            print("Нет файлов сохранения.");
            return;
        }

        var name = menuSavedTree(allTrees);
        if (!name.isEmpty())
            if (this.presenter.deleteTree(menuSavedTree(allTrees))) {
                print("Древо успешно удалено.");
            } else {
                print("Ошбика при удалении файла сохранения.");
            }

    }

    private String menuSavedTree(List<String> trees) {
        Collections.sort(trees);
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        List<String> namesOnPage = new LinkedList<>();
        int pageNumber = 0;
        for (var name : trees) {
            namesOnPage.add(name);
            if (namesOnPage.size() >= CONSOLE_LINES - 3 ||
                    namesOnPage.size() + pageNumber * 10 == trees.size()) {
                menuData.put("СОХРАНЕННЫЕ ДРЕВА " + ++pageNumber + ":", namesOnPage);
                namesOnPage = new LinkedList<>();
            }
        }

        int nameIndex = StartMenu(menuData, 1) - 1;
        return nameIndex < 0 ? "" : trees.get(nameIndex);
    }

    private int StartMenu(Map<String, List<String>> menuData, int taskId) {
        var menu = new MenuRender(menuData, CONSOLE_LINES, true, true, "", "", "> ", "");
        return menu.startRenderMenu(taskId - 1);
    }

    private boolean yesNoDialog(String message) {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put(message, Arrays.asList("Да", "Нет"));
        int commandKey = StartMenu(menuData, 1);
        return commandKey == 1;
    }

    private void appClose() {
        cmdManager.consoleClear();
        cmdManager.PrintText("Приложение завершило работу.");
    }

    private void stubFunction() {
        print("Функционал в разработке.");
    }
}