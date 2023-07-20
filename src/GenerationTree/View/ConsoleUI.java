package GenerationTree.View;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import GenerationTree.Presenter.Presenter;
import GenerationTree.View.MenuRender.ConsoleManager;
import GenerationTree.View.MenuRender.MenuRender;

public class ConsoleUI implements View {

    private Presenter presenter;
    private ConsoleManager cmdManager;

    public ConsoleUI() {
        cmdManager = new ConsoleManager();
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        clsField();
        var appIsRun = true;
        while (appIsRun) {
            String surname = cmdManager.inputText("Введите фамилию семьи: ");
            presenter.setTreeService(surname);

            appIsRun = startupMenu(surname);
        }
        appClose();
    }

    @Override
    public void print(String text) {
        cmdManager.PrintText(text);
        cmdManager.inputText("      Для проболжения нажмите Enter...");
    }

    private void clsField() {
        String header = "ПРОГРАММА: Генеалогическое древо семьи. Версия 0.000.00 pre-Alpha                                ";
        cmdManager.consoleClear();
        cmdManager.PrintText(header);
        cmdManager.PrintText("=".repeat(header.length()));
    }

    private boolean startupMenu(String surname) {

        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put("Семья: " + surname, Arrays.asList("Новая персона", "Найти персону", "Удалить персону"));
        menuData.put("-----", Arrays.asList("Ввод другого древа", "ВЫХОД"));
        int commandKey = 1;
        var isActiveMenu = true;
        while (isActiveMenu) {
            clsField();
            commandKey = StartMenu(menuData, commandKey);
            switch (commandKey) {
                case 1, 2, 3:
                    stubFunction();
                    break;
                case 4:
                    return true;
                default:
                    var isClosed = yesNoDialog("Закрыть приложение?");
                    if (isClosed)
                        return !isClosed;
                    else
                        break;
            }
        }
        return true;
    }

    private int StartMenu(Map<String, List<String>> menuData, int taskId) {
        var menu = new MenuRender(menuData, 10, true, true, "", "", "> ", "");
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