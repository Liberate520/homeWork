package com.britenight.MVP.View;

import com.britenight.MVP.Presenter.Fabric;
import com.britenight.MVP.Presenter.Presenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView<E extends Comparable<E>> implements View {

    private final Presenter<E> presenter;

    public ConsoleView(Fabric<E> fabric) {
        this.presenter = new Presenter<E>(this, fabric);
    }

    //region View

    @Override
    public void start() {
        boolean exitFlag;
        do {
            exitFlag = mainMenu();
        } while (!exitFlag);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public Map<String, String> prompt(Map<String, String> idTitle) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : idTitle.entrySet()) {
            String input = getInput("Введите " + entry.getValue() + ":\n");
            result.put(entry.getKey(), input);
        }
        return result;
    }

    //endregion

    //region Utils

    private String getInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private int showMenu(String menu, int min, int max) {
        int res = -1;
        do {
            System.out.println("===========");
            System.out.println(menu);
            try {
                res = Integer.parseInt(getInput("\nSelect: "));
            } catch (Exception e) {
            }
        } while (!(res >= min && res <= max));
        return res;
    }

    //endregion

    //region Menus

    private boolean mainMenu() {
        switch (showMenu("1 - See model\n" +
                "2 - Manage objects\n" +
                "3 - Import/Export model\n" +
                "\n0 - Exit", 0, 3)) {
            case 0:
                return true;
            case 1:
                presenter.printModel();
                break;
            case 2:
                boolean exitFlag;
                do {
                    exitFlag = objectsMenu();
                } while (!exitFlag);
                break;
            case 3:
                do {
                    exitFlag = fileMenu();
                } while (!exitFlag);
                break;
        }
        return false;
    }

    private boolean objectsMenu() {
        switch (showMenu("1 - See objects\n" +
                "2 - Create object\n" +
                "3 - Remove object\n" +
                "4 - Manage relations\n" +
                "5 - Sort objects\n" +
                "\n0 - Exit", 0, 5)) {
            case 0:
                return true;
            case 1:
                presenter.getObjects();
                break;
            case 2:
                presenter.addObject(this::prompt);
                break;
            case 3:
                presenter.removeObject(presenter.selectObject(this::getInput));
                break;
            case 4:
                boolean exitFlag;
                E tmp = presenter.selectObject(this::getInput);
                if (tmp == null) break;
                do {
                    exitFlag = relationsMenu(tmp);
                } while (!exitFlag);
                break;
            case 5:
                do {
                    exitFlag = sortMenu();
                } while (!exitFlag);
                break;
        }
        return false;
    }

    private boolean relationsMenu(E object) {
        switch (showMenu("1 - See relations\n" +
                "2 - Add parent\n" +
                "3 - Add child\n" +
                "4 - Remove Parent\n" +
                "5 - Remove Child\n" +
                "\n0 - Exit", 0, 5)) {
            case 0:
                return true;
            case 1:
                presenter.printRelations(object);
                break;
            case 2:
                presenter.addParent(object, presenter.selectObject(this::getInput));
                break;
            case 3:
                presenter.addChild(object, presenter.selectObject(this::getInput));
                break;
            case 4:
                presenter.removeParent(object, presenter.selectParent(this::getInput, object));
                break;
            case 5:
                presenter.removeChild(object, presenter.selectChild(this::getInput, object));
                break;
        }
        return false;
    }

    private boolean fileMenu() {
        switch (showMenu("1 - Export\n" +
                "2 - Import\n" +
                "\n0 - Exit", 0, 2)) {
            case 0:
                return true;
            case 1:
                String fileName = getInput("File name: ");
                presenter.saveToFile(fileName);
                break;
            case 2:
                fileName = getInput("File name: ");
                presenter.readFromFile(fileName);
                break;
        }
        return false;
    }

    private boolean sortMenu() {
        switch (showMenu("1 - Sort ascending\n" +
                "2 - Sort descending\n" +
                "\n0 - Exit", 0, 2)) {
            case 0:
                return true;
            case 1:
                presenter.sortAscending();
                break;
            case 2:
                presenter.sortDescending();
                break;
        }
        return false;
    }

    //endregion
}
