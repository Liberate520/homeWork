package GenerationTree.View.ConsoleUI;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import GenerationTree.Model.Person.Structs.Gender;
import GenerationTree.View.ConsoleUI.MenuRender.MenuRender;

public class ConsoleMenu {

    private final int CONSOLE_LINES = 12;
    private boolean runMenu;

    ConsoleMenu() {
        runMenu = true;
    }

    int yesNoCancelDialog(String message) {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put(message, Arrays.asList("Да", "Нет", "Отмена"));
        return drawDialogMenu(menuData, 0);
    }

    boolean yesNoDialog(String message) {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put(message, Arrays.asList("Да", "Нет"));
        int commandKey = drawDialogMenu(menuData, 1);
        return commandKey == 1;
    }

    public Gender genderDialog() {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put("Выберите пол:", Arrays.asList(Gender.MALE.toString(), Gender.FEMALE.toString()));
        int key = drawDialogMenu(menuData, 0);
        if (key == 1) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    int contentMenu(Collection<String> members, String headerText) {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        List<String> namesOnPage = new LinkedList<>();
        int pageNumber = 0;
        for (var name : members) {
            namesOnPage.add(name);
            if (namesOnPage.size() >= CONSOLE_LINES - 3 ||
                    namesOnPage.size() + pageNumber * 10 == members.size()) {
                menuData.put(headerText + " " + ++pageNumber + ":", namesOnPage);
                namesOnPage = new LinkedList<>();
            }
        }
        return drawContentMenu(menuData, 1) - 1;
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable fEnd) {
        selectedMenu(menuData, f1, null, null, null, null, null, null, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, null, null, null, null, null, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, null, null, null, null, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, f4, null, null, null, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable f5,
            Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, f4, f5, null, null, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable f5,
            Runnable f6, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, f4, f5, f6, null, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable f5,
            Runnable f6, Runnable f7, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, f4, f5, f6, f7, null, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable f5,
            Runnable f6, Runnable f7, Runnable f8, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, f4, f5, f6, f7, f8, null, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable f5,
            Runnable f6, Runnable f7, Runnable f8, Runnable f9, Runnable fEnd) {
        selectedMenu(menuData, f1, f2, f3, f4, f5, f6, f7, f8, f9, null, fEnd);
    }

    void selectedMenu(Map<String, List<String>> menuData,
            Runnable f1, Runnable f2, Runnable f3, Runnable f4, Runnable f5,
            Runnable f6, Runnable f7, Runnable f8, Runnable f9, Runnable f10,
            Runnable fEnd) {
        int commandKey = 1;
        openMenu();
        while (runMenu) {
            commandKey = drawContentMenu(menuData, commandKey == 0 ? 1 : commandKey);
            switch (commandKey) {
                case 1:
                    if (f1 != null)
                        f1.run();
                    else
                        fEnd.run();
                    break;
                case 2:
                    if (f2 != null)
                        f2.run();
                    else
                        fEnd.run();
                    break;
                case 3:
                    if (f3 != null)
                        f3.run();
                    else
                        fEnd.run();
                    break;
                case 4:
                    if (f4 != null)
                        f4.run();
                    else
                        fEnd.run();
                    break;
                case 5:
                    if (f5 != null)
                        f5.run();
                    else
                        fEnd.run();
                    break;
                case 6:
                    if (f6 != null)
                        f6.run();
                    else
                        fEnd.run();
                    break;
                case 7:
                    if (f7 != null)
                        f7.run();
                    else
                        fEnd.run();
                    break;
                case 8:
                    if (f8 != null)
                        f8.run();
                    else
                        fEnd.run();
                    break;
                case 9:
                    if (f9 != null)
                        f9.run();
                    else
                        fEnd.run();
                    break;
                case 10:
                    if (f10 != null)
                        f10.run();
                    else
                        fEnd.run();
                    break;
                default:
                    fEnd.run();
                    break;
            }
        }
    }

    void openMenu() {
        this.runMenu = true;
    }

    void closeMenu() {
        this.runMenu = false;
    }

    private int drawContentMenu(Map<String, List<String>> menuData, int taskId) {
        var menu = new MenuRender(menuData, CONSOLE_LINES, true, true, "", "", "> ", "");
        return menu.startRenderMenu(taskId - 1);
    }

    private int drawDialogMenu(Map<String, List<String>> menuData, int taskIndex) {
        var menu = new MenuRender(menuData, 0, false, false, "", "", "", "");
        return menu.startRenderMenu(taskIndex);
    }
}